package Main.Entities;

import Main.Utils.Sexo;
import Main.Utils.Tipo;

public class Pet {

        private String nome;
        private String sobrenome;
        private Tipo tipo;
        private Sexo sexo;
        private Integer numero;
        private String cidade;
        private String rua;
        private Double idade;
        private Double peso;
        private String raca;

        public Pet() {

        }

        public Pet(String nome, String sobrenome, Tipo tipo, Sexo sexo, Integer numero, String cidade, String rua,
        Double idade, Double peso, String raca) {

                this.nome = nome;
                this.sobrenome = sobrenome;
                this.tipo = tipo;
                this.sexo = sexo;
                this.numero = numero;
                this.cidade = cidade;
                this.rua = rua;
                this.idade = idade;
                this.peso = peso;
                this.raca = raca;
        }

        public String toString() {
                return nome + " " + sobrenome + "\n" + tipo + "\n" + sexo + "\n" + numero + "," + cidade + ", " + rua + "\n" + idade + "anos" + "\n" + peso + "kgs" + "\n" + raca;
            }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getSobrenome() {
                return sobrenome;
        }

        public void setSobrenome(String sobrenome) {
                this.sobrenome = sobrenome;
        }

        public Tipo getTipo() {
                return tipo;
        }

        public void setTipo(Tipo tipo) {
                this.tipo = tipo;
        }

        public Sexo getSexo() {
                return sexo;
        }

        public void setSexo(Sexo sexo) {
                this.sexo = sexo;
        }

        public Integer getNumero() {
                return numero;
        }

        public void setNumero(Integer numero) {
                this.numero = numero;
        }

        public String getCidade() {
                return cidade;
        }

        public void setCidade(String cidade) {
                this.cidade = cidade;
        }

        public String getRua() {
                return rua;
        }

        public void setRua(String rua) {
                this.rua = rua;
        }

        public Double getIdade() {
                return idade;
        }

        public void setIdade(Double idade) {
                this.idade = idade;
        }

        public Double getPeso() {
                return peso;
        }

        public void setPeso(Double peso) {
                this.peso = peso;
        }

        public String getRaca() {
                return raca;
        }

        public void setRaca(String raca) {
                this.raca = raca;
        }


}
