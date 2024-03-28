let poo = [];
let totHorasPoo = 60;

function carregaBD() {
            //        Nome,            nP1,nP2,nP3,faltas,exame
            poo[0] = ["Carlos Borba",   10,  8,  7,     5,   -1];
            poo[1] = ["Silvia Almeida",  6,  8,  7,     2,   -1];
            poo[2] = ["Mariana Tomaz",   7,  9,  5,     0,   -1];
            poo[3] = ["Juan Dornelles",  6,  6,  5,     7,    7];
            poo[4] = ["Mario Castilhos", 3, 10,  7,     1,    6];
}

function frequencia(matricula){
    f = poo[matricula][4];
    freq = ((totHorasPoo - (f * 2)) / totHorasPoo) * 100;
    return freq;
}

function media(matricula){
    return (poo[matricula][1] + poo[matricula][2] + poo[matricula][3]) / 3;
}

function aprovado(matricula){
    let freq = frequencia(matricula);
    let mediaCalc = media(matricula);
    let resposta = "none";
    if (freq >= 75 && mediaCalc >= 7) {
        resposta = "Aprovado";
    } else {
        resposta = "Reprovado";
    }
    return resposta;
}

function academico(matriculaInformada,opcaoDesejada) {
    let resposta = "";
    if (matriculaInformada < 1000 || matriculaInformada > 1004) {
        return "Matricula invalida";
    }
    let matricula = matriculaInformada - 1000;
    switch (opcaoDesejada) {
        case "frequencia":
            resposta += "frequencia: " + frequencia(matricula).toFixed(2) + "%";
            break;
        case "notasParciais":
            resposta = "notas parciais: " + poo[matricula][1] + ", " + poo[matricula][2] + ", " + poo[matricula][3];
            break;
        case "mediaFinal":
            let medCalc = media(matricula);
            resposta = "media final: " + medCalc.toFixed(2);
            break;
        case "aprovacao":
            resposta = aprovado(matricula);
            break;
        default:
            resposta = "opção inválida!"
    }
    return resposta;
}
