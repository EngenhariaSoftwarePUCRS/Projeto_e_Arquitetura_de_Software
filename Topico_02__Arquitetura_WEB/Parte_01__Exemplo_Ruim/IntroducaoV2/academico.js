let poo = [];
let totHorasPoo = 60;

function carregaBD() {
            //        Nome,            nP1,nP2,nP3,faltas,exame
            poo[0] = ["Carlos Borba",   10,  8,  7,     5,   -1];
            poo[1] = ["Silvia Almeida",  6,  8,  7,     2,   -1];
            poo[2] = ["Mariana Tomaz",   7,  9,  5,     0,   -1];
            poo[3] = ["Juan Dornelles",  6,  6,  5,     7,    7];
            poo[4] = ["Mario Castilhos", 3, 10,  7,     1,    6];
            document.getElementById("resposta").innerHTML = "teste BD";
}

function academico() {
    let matriculaInformada = document.getElementById("matriculaInformada").value;
    let selectElement = document.getElementById("opcaoDesejada");
    let opcaoDesejada = selectElement.options[selectElement.selectedIndex].value;
    let resposta = "none";
    if (matriculaInformada < 1000 || matriculaInformada > 1004) {
        document.getElementById("resposta").innerHTML = "Matricula invalida";
        return;
    }
    let matricula = matriculaInformada - 1000;
    let f = 0;
    let freq = 0;
    let media = 0;
    switch (opcaoDesejada) {
        case "frequencia":
            f = poo[matricula][4];
            freq = ((totHorasPoo - (f * 2)) / totHorasPoo) * 100;
            resposta += "frequencia: " + freq.toFixed(2) + "%";
            break;
        case "notasParciais":
            resposta = "notas parciais: " + poo[matricula][1] + ", " + poo[matricula][2] + ", " + poo[matricula][3];
            break;
        case "mediaFinal":
            media = (poo[matricula][1] + poo[matricula][2] + poo[matricula][3]) / 3;
            resposta = "media final: " + media.toFixed(2);
            break;
        case "aprovacao":
            // Frequencia
            f = poo[matricula][4];
            freq = ((totHorasPoo - (f * 2)) / totHorasPoo) * 100;
            // Media
            media = (poo[matricula][1] + poo[matricula][2] + poo[matricula][3]) / 3;
            if (freq >= 75 && media >= 7) {
                resposta = "Aprovado";
            } else {
                resposta = "Reprovado";
            }
            break;
        default:
            resposta = "opção inválida!"
    }
    document.getElementById("resposta").innerHTML =
        "Aluno: " + matriculaInformada + ", " + resposta;
}
