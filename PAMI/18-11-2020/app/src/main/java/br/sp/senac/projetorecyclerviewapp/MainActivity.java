package br.sp.senac.projetorecyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Livros> lstLivros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inserindo os livros no arrayList vazio
        lstLivros = new ArrayList<>();
        lstLivros.add(new Livros("Bacurau","Faroeste/Thriller","Os moradores de Bacurau, um pequeno povoado do sertão brasileiro, descobrem que a comunidade não consta mais em qualquer mapa. Aos poucos, eles percebem algo estranho na região: enquanto drones passeiam pelos céus, estrangeiros chegam à cidade. Quando carros são baleados e cadáveres começam a aparecer, Teresa, Domingas, Acácio, Plínio, Lunga e outros habitantes chegam à conclusão de que estão sendo atacados. Agora, o grupo precisa identificar o inimigo e criar coletivamente um meio de defesa.",R.drawable.bacurau));
        lstLivros.add(new Livros("Bloodshot","Ação/Aventura","Depois de ser morto em combate, o soldado Ray Garrison é trazido de volta à vida com um exército de nanotecnologia em suas veias e poderes sobre-humanos: uma incrível força e a habilidade de se curar instantaneamente. Sem memória, ele está decidido a descobrir a verdade sobre quem realmente é.",R.drawable.bloodshot));
        lstLivros.add(new Livros("Bad Boys para Sempre", "Ação/Comédia", "Os policiais Mike Lowery e Marcus Burnett se juntam para derrubar o líder de um cartel de drogas em Miami. A recém-criada equipe de elite do departamento de polícia de Miami, ao lado de Mike e Marcus, enfrenta o implacável Armando Armas.", R.drawable.badboys));
        lstLivros.add(new Livros("Malévola: Dona do Mal", "Conto de fadas/Ação", "Malévola e sua afilhada Aurora começam a questionar os complexos laços familiares que as prendem à medida que são puxadas em direções diferentes por casamentos, aliados inesperados e novas forças sombrias em jogo.", R.drawable.malevola));
        lstLivros.add(new Livros("The Old Guard", "Ação/Fantasia", "The Old Guard é um filme de ação e ficção científica de super-heróis americano de 2020 dirigido por Gina Prince-Bythewood e escrito por Greg Rucka, baseado na série de histórias em quadrinhos de mesmo nome de Rucka e ilustrado por Leandro Fernández.", R.drawable.theoldguard));
        lstLivros.add(new Livros("Ma", "Suspense", "Uma mulher solteira de meia-idade faz amizade com alguns adolescentes e decide deixá-los festejar em sua casa. Mas começam a acontecer coisas que fazem os garotos questionar a intenção da anfitriã.", R.drawable.ma));
        lstLivros.add(new Livros("Dunkirk", "Guerra/Ação", "Durante a Segunda Guerra Mundial, a Alemanha avança rumo à França e cerca as tropas aliadas nas praias de Dunkirk. Sob cobertura aérea e terrestre das forças britânicas e francesas, as tropas são lentamente evacuadas da praia.", R.drawable.dunkirk));
        lstLivros.add(new Livros("Superação: O Milagre da Fé", "Drama", "Durante um passeio com a família em uma manhã de inverno no Lago St Louis, no Missouri, o menino John Smith, de apenas 14 anos, sofre uma queda e se afoga por mais de 15 minutos. Chegando ao hospital, John é considerado morto por mais de uma hora até que sua mãe, Joyce Smith, ao lado do pai e de um pastor, junta todas as suas forças e pede a Deus para que seu filho sobreviva. Sua prece poderosa é responsável por um milagre inédito.", R.drawable.superacao));
        lstLivros.add(new Livros("Dolittle","Aventura/Infantil","O Dr. Dolittle vive com uma variedade de animais exóticos e conversa com eles diariamente. Quando a jovem rainha Victoria fica doente, o excêntrico médico e seus amigos peludos embarcam em uma aventura épica em uma ilha mítica para encontrar a cura.",R.drawable.dolittle));
        lstLivros.add(new Livros("SCOOBY! O Filme","Animação/Infantil","Scooby e sua turma encaram o seu maior e mais difícil mistério de todos os tempos: um plano maligno para liberar o cão fantasma, Cérbero, no mundo. Enquanto corre para impedir esse \"apocãolipse\" global, a turma descobre que Scooby tem um legado secreto e um destino épico maior do que qualquer um podia imaginar.",R.drawable.scooby));
        lstLivros.add(new Livros("Coringa", "Crime/Drama", "O Joker é um supervilão fictício que aparece nos livros de banda desenhada norte-americanos publicados pela editora estadunidense DC Comics. Foi criado por Jerry Robinson, Bill Finger e Bob Kane e apareceu pela primeira vez em Batman #1.", R.drawable.coringa));
        lstLivros.add(new Livros("O Homem Invisível", "Terror/Thriller", "Depois de forjar o próprio suicídio, um cientista enlouquecido usa seu poder para se tornar invisível e aterrorizar sua ex-namorada. Quando a polícia se recusa a acreditar em sua história, ela decide resolver o assunto por conta própria.", R.drawable.homeminvisivel));
        lstLivros.add(new Livros("Parasita", "Thriller/Comédia", "Toda a família de Ki-taek está desempregada, vivendo em um porão sujo e apertado, mas uma obra do acaso faz com que ele comece a dar aulas de inglês a uma garota de família rica. Fascinados com a vida luxuosa destas pessoas, pai, mãe e filhos bolam um plano para se infiltrarem também na família burguesa, um a um. No entanto, os segredos e mentiras necessários à ascensão social custam caro a todos.", R.drawable.parasita));
        lstLivros.add(new Livros("Sonic: O Filme", "Infantil/Comédia", "Sonic, o porco-espinho azul mais famoso do mundo, se junta com os seus amigos para derrotar o terrível Doutor Eggman, um cientista louco que planeja dominar o mundo, e o Doutor Robotnik, responsável por aprisionar animais inocentes em robôs.", R.drawable.sonic));
        lstLivros.add(new Livros("Extraordinário", "Drama/Comédia", "Auggie Pullman é um garoto que nasceu com uma deformidade facial, o que fez com que passasse por 27 cirurgias plásticas. Aos 10 anos, ele irá frequentar uma escola regular, como qualquer outra criança, pela primeira vez. No quinto ano, ele precisa se esforçar para conseguir se encaixar em sua nova realidade.", R.drawable.extraordinario));
        lstLivros.add(new Livros("O Grinch", "Infantil/Fantasia", "O rabugento Grinch faz de tudo para acabar com o Natal dos cidadãos de Quemlândia. Seu plano é roubar das pessoas tudo que tenha ligação com a data, até que a menina Cindy Lou Who resolve ficar amiga dele.", R.drawable.grinch));
        lstLivros.add(new Livros("O Caso Richard Jewell", "Drama/Crime", "A história real de Richard Jewell, segurança que se tornou um dos principais suspeitos de bombardear as Olimpíadas de Atlanta, em 1996, depois de ajudar inocentes a fugirem do local e avisar da existência de um dos explosivos.", R.drawable.richardjewell));
        lstLivros.add(new Livros("Aladdin", "Infantil/Romance", "Um jovem humilde descobre uma lâmpada mágica, com um gênio que pode lhe conceder desejos. Agora o rapaz quer conquistar a moça por quem se apaixonou, mas o que ele não sabe é que a jovem é uma princesa que está prestes a se noivar. Agora, com a ajuda do gênio, ele tenta se passar por um príncipe para conquistar o amor da moça e a confiança de seu pai.", R.drawable.aladdin));
        lstLivros.add(new Livros("Crônicas de Natal", "Aventura/Infantil", "The Christmas Chronicles é um filme de comédia de Natal americano de 2018 dirigido por Clay Kaytis a partir de um roteiro de Matt Lieberman.", R.drawable.cronicasdenatal));
        lstLivros.add(new Livros("Thor: Ragnarok", "Ação/Ficção científica", "Após anos afastado, Thor retorna para casa e descobre que seu pai Odin, rei de Asgard, está desaparecido. Após encontrá-lo, ele toma conhecimento de sua irmã mais velha, Hela, a poderosa e implacável deusa da morte. Com o auxílio de Loki, ele enfrenta Hela, mas durante a batalha, Thor acaba preso em Sakaar, um planeta do outro lado do universo. Agora, ele precisa correr contra o tempo para voltar a Asgard e impedir o Ragnarok, a destruição de seu mundo.", R.drawable.thorragnarok));


        //declarando a variavel xml enviando para o java
        RecyclerView mRecyclerView = findViewById(R.id.id_recyclerView);

        //Instânciando o adaptador com os valores necessários
        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(getApplicationContext(), lstLivros);
        //Criando o layout para inserção dos valores

        //LayoutManager não é necessário inserção de colunas - pode ser utilizado na vertical ou horizontal
       // mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL,true));

        //GriLayoutManager necessário a inserção de colunas
        mRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));

        //Para melhorar a performance do RecyclerView na listagem
        mRecyclerView.setHasFixedSize(true);

        //Inserindo os valores na lista do RecyclerView
        mRecyclerView.setAdapter(mAdapter);


    }
}
