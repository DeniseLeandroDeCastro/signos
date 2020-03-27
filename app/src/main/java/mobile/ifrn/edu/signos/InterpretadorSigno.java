package mobile.ifrn.edu.signos;

//Classe que fará o cálculo para retornar o signo correto


import java.util.ArrayList;

public class InterpretadorSigno {

    //Array com todos os signos existentes
    private ArrayList<Signo> signos = new ArrayList<Signo>() {
        {
            add(new Signo (20, 1, 18, 2, "Aquário", "@drawable/aquario"));
            add(new Signo (19, 2, 20, 3, "Peixes", "@drawable/peixes"));
            add(new Signo (21, 3, 19, 4, "Áries", "@drawable/aries"));
            add(new Signo (20, 4, 20, 5, "Touro", "@drawable/touro"));
            add(new Signo (21, 5, 20, 6, "Gêmeos", "@drawable/gemeos"));
            add(new Signo (21, 6, 22, 7, "Câncer", "@drawable/cancer"));
            add(new Signo (23, 7, 22, 8, "Leão", "@drawable/leao"));
            add(new Signo (23, 8, 22, 9, "Virgem", "@drawable/virgem"));
            add(new Signo (23, 9, 22, 10, "Libra", "@drawable/libra"));
            add(new Signo (23, 10, 21, 11, "Escorpião", "@drawable/escorpiao"));
            add(new Signo (22, 11, 21, 12, "Sagitário", "@drawable/sagitario"));
            add(new Signo (22, 12, 19, 1, "Capricórnio", "@drawable/capricornio"));
        }
    };

    //Método para interpretar o signo
    public Signo interpretar(int dia, int mes) {
        Signo signo = null;

        for(Signo s: signos) {
            if(s.getMesinicio() == mes && dia >= s.getDiainicio()) {
                signo = s;
                break;
            } else if(s.getMesfim() == mes && dia <= s.getDiafim()) {
                signo = s;
                break;
            }
        }

        return signo;
    }

}
