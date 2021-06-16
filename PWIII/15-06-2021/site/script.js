produtosArray = []
const meses = ["Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul","Ago","Set","Out","Nov","Dez"];
function paginate(array, page_size, page_number) {
    return array.slice((page_number - 1) * page_size, page_number * page_size);
}

function liPage(array, pageSelected) {
    let html = ""
    for (element of array) {
        if (element == pageSelected) {
            html += `
                <li class="page-item active">
                    <a href="#">${element}</a>
                </li>
            `;
        } else {
            html += `
                <li class="page-item">
                    <a href="#">${element}</a>
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
      to = current + half ;
    }
    
    let from = to - max;
  
    return Array.from({length: max}, (_, i) => (i + 1) + from);
}

function attPages(pageSelected) {
    let ul = document.getElementById('pagination');
    let nPages = (produtosArray.length >= 5) ? Math.trunc(produtosArray.length/5) : 1; 
    ul.innerHTML = `
        <li class="page-item">
            <a href="#">Anterior</a>
        </li>
        ${liPage(pageNumbers(nPages, 5, pageSelected), pageSelected)}
        <li class="page-item">
            <a href="#">Próximo</a>
        </li>
    `
};

function attProdutos(pageSelected) {
    let pages = paginate(produtosArray, 5, pageSelected)
    tbody = document.getElementById('tbodyContent');
    pages.forEach((element, index, array) => {
        let data = new Date(element.createdAt);
        let dataFormatada = ((data.getDate() + " " + meses[(data.getMonth())] + " " + data.getFullYear()));
        tr = document.createElement('tr');
        tr.innerHTML = `
            <td>
                <span class="custom-checkbox">
                    <input type="checkbox" class="checkbox${index}" name="options[]" value="${element.codigo}">
                    <label for="checkbox${index}"></label>
                </span>
            </td>
            <td>${element.codigo}</td>
            <td>${element.nome}</td>
            <td><img src="${element.imagem}"></td> 
            <td>${element.descricao}</td> 
            <td>${element.quantidade}</td>
            <td>${element.preco}</td>
            <td>${dataFormatada}</td>
            <td>
                <a href="#" class="edit">
                    <i class="material-icons" data-toggle="tooltip" title="Edit">edit</i>
                </a>
                <a href="#" class="delete">
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
        attProdutos(1);
    }).catch(error => {

    });
