produtosArray = []
pageS = 1;
pageMax = 1;
imgChanged = -1;
const meses = ["Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul","Ago","Set","Out","Nov","Dez"];
function paginate(array, page_size, page_number) {
    return array.slice((page_number - 1) * page_size, page_number * page_size);
}


function editModal(codigo) {
    axios.get(`http://pwiii-15-06-2021.herokuapp.com/produtos/${codigo}`)
        .then(response => {
            let element = response.data;
            $('#editProduct-name').val(element.nome);
            $('#editProduct-description').val(element.descricao);
            $('#editProduct-price').val(element.preco);
            $('#editProduct-amount').val(element.quantidade);
            document.getElementById('editImage').setAttribute('onchange', `javascript:imgChanged = ${element.codigo}`);
            document.getElementById('editImage').setAttribute('path', `${element.imagem}`);
            document.getElementById('editProduct').setAttribute('onclick', `javascript:clickEditModal(${element.codigo}, event)`);
        }).catch(err => {
            console.log(err);
        });
};

function clickEditModal(codigo, event) {
    event.preventDefault();
    _name = $('#editProduct-name').val();
    _description = $('#editProduct-description').val();
    _price = $('#editProduct-price').val();
    _amount = $('#editProduct-amount').val();
    if (imgChanged == codigo) {
        var formData = new FormData();
        var imagefile = document.querySelector('#editImage');
        formData.append("image", imagefile.files[0]);
        axios.post('http://pwiii-15-06-2021.herokuapp.com/upload', formData)
        .then(response => {
            axios.put(`http://pwiii-15-06-2021.herokuapp.com/produtos/${codigo}`, {nome: _name,descricao: _description,preco: _price,quantidade: _amount,imagem: response.data.image_path})
                .then(response => {
                    location.reload();
                });
        }) .catch(error => {
            console.log(error);
        })
    } else {
        let imgPath = document.getElementById('editImage').getAttribute('path')
        axios.put(`http://pwiii-15-06-2021.herokuapp.com/produtos/${codigo}`, {nome: _name,descricao: _description,preco: _price,quantidade: _amount,imagem: imgPath})
            .then(response => {
                location.reload();
            });
    }
};

function deleteProduto(codigo) {
    axios.delete(`http://pwiii-15-06-2021.herokuapp.com/produtos/${codigo}`)
        .then(response => {
            location.reload()
        }).catch(err => {
            console.log(err);
        });
};

function liPage(array, pageSelected) {
    let html = ""
    for (element of array) {
        if (element == pageSelected) {
            html += `
                <li class="page-item active">
                    <a href="#" class="page-link" onclick="javascript:attPages(${element});">${element}</a>
                </li>
            `;
        } else {
            html += `
                <li class="page-item">
                    <a href="#" class="page-link" onclick="javascript:attPages(${element});">${element}</a>
                </li>
            `;
        }
    }
    return html;
}

const pageNumbers = (total, max, current) => {
    const half = Math.floor(max / 2);
    let to = max;
    
    if(current + half >= total) {
      to = total;
    } else if(current > half) {
      to = current + half;
    }
    
    let from = to - max;
  
    return Array.from({length: max}, (_, i) => (i + 1) + from);
}

function attPages(pageSelected) {
    pageS = pageSelected;
    let ul = document.getElementById('pagination');
    let nPages = (produtosArray.length >= 5) ? Math.trunc(produtosArray.length/5) : 1; 
    if (produtosArray.length%5 > 0)
        nPages = nPages + 1
    pageMax = nPages;
    if (nPages < 5) {
        let listN = []
        for (let nC=1;nC<=nPages;nC++) {
            listN.push(nC);
        }
        liF = liPage(listN, pageSelected);
    } else {
        liF = liPage(pageNumbers(nPages, 5, pageSelected), pageSelected);
    }
    ul.innerHTML = `
        <li class="page-item">
            <a href="#" onclick="javascript:if(pageS-1>=1){attPages(pageS-1)}">Anterior</a>
        </li>
        ${liF}
        <li class="page-item">
            <a href="#" onclick="javascript:if(pageS+1<=pageMax){attPages(pageS+1)}">Próximo</a>
        </li>
    `;
    attProdutos(pageSelected)
};

function attProdutos(pageSelected) {
    let pages = paginate(produtosArray, 5, pageSelected)
    tbody = document.getElementById('tbodyContent');
    tbody.innerHTML = "";
    pages.forEach((element, index, array) => {
        let data = new Date(element.createdAt);
        let dataFormatada = ((data.getDate() + " " + meses[(data.getMonth())] + " " + data.getFullYear()));
        tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${element.codigo}</td>
            <td>${element.nome}</td>
            <td><img class="product-image" height="50" width="50" src="http://pwiii-15-06-2021.herokuapp.com/uploads/images/${element.imagem}"></td> 
            <td>${element.descricao}</td> 
            <td>${element.quantidade}</td>
            <td>R$ ${element.preco}</td>
            <td>${dataFormatada}</td>
            <td>
                <a href="#editProduto" class="edit" data-toggle="modal" onclick="editModal(${element.codigo})">
                    <i class="material-icons" data-toggle="tooltip" title="Edit">edit</i>
                </a>
                <a href="#" class="delete" onclick="deleteProduto(${element.codigo})">
                    <i class="material-icons" data-toggle="tooltip" title="Delete">delete</i>
                </a>
            </td>
        `;
        tbody.appendChild(tr);
        document.getElementsByClassName('hint-text')[0].innerHTML = `Mostrando <b>${pages.length}</b> itens de <b>${produtosArray.length}</b>`
    })
}
axios.get('http://pwiii-15-06-2021.herokuapp.com/produtos')
    .then(response => {
        produtosArray = response.data;
        attPages(1);
    }).catch(error => {
        console.log(error)
    });

$('#createProduct').click(function(event) {
    event.preventDefault();
    var formData = new FormData();
    var imagefile = document.querySelector('#sendImage');
    formData.append("image", imagefile.files[0]);
    _name = $('#addProduct-name').val();
    _description = $('#addProduct-description').val();
    _price = $('#addProduct-price').val();
    _amount = $('#addProduct-amount').val();
    axios.post('http://pwiii-15-06-2021.herokuapp.com/upload', formData)
        .then(response => {
            axios.post('http://pwiii-15-06-2021.herokuapp.com/produtos', {nome: _name,descricao: _description,preco: _price,quantidade: _amount,imagem: response.data.image_path})
                .then(response => {
                    location.reload();
                });
        }) .catch(error => {
            console.log(error);
        })
});