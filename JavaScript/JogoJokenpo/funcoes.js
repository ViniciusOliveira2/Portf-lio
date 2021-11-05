var pontuacao1 = 0;
var pontuacao2 = 0;

function Exibir(){
    var escolha;
    var radios = document.getElementsByName("PPT");
    var computador = Math.floor(Math.random(1, 0) * 100);
    var escolhaComputador;
    var vitoria;
    var stringona;

    for (var i = 0; i < radios.length; i++){
        if (radios[i].checked == true){
            escolha = radios[i].value;
        }
    }

    if (computador <= 99){
        escolhaComputador = 'Tesoura';

        if (computador <= 66){
            escolhaComputador = 'Papel';

            if(computador <= 33){
                escolhaComputador = 'Pedra';
            }
        }
    }

    if (escolhaComputador == escolha){
        alert("Empate.\n\nPontuação Geral - Jogador " + pontuacao1 + " x " + pontuacao2 + " Computador");
    } else{
        if (escolha == 'Pedra'){
            if (escolhaComputador == 'Papel'){
                vitoria = false;
                stringona = 'Papel cobre a pedra';
            } else{
                vitoria = true;
                stringona = 'Pedra quebra tesoura';
            }
        }

        if (escolha == 'Papel'){
            if (escolhaComputador == 'Tesoura'){
                vitoria = false;
                stringona = 'Tesoura corta papel';
            } else{
                vitoria = true;
                stringona = 'Papel cobre a pedra';
            }
        }

        if (escolha == 'Tesoura'){
            if (escolhaComputador == 'Pedra'){
                vitoria = false;
                stringona = 'Pedra quebra tesoura';
            } else{
                vitoria = true;
                stringona = 'Tesoura corta papel';
            }
        }

        if (vitoria){
            pontuacao1++;
            alert(stringona + "\n\nPontuação Geral - Jogador " + pontuacao1 + " x " + pontuacao2 + " Computador");
        } else{
            pontuacao2++;
            alert(stringona + "\n\nPontuação Geral - Jogador " + pontuacao1 + " x " + pontuacao2 + " Computador");
        }
    }
}