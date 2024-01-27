enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(
    var nome: String,
    val duracao: Int = 60,
    var descricao: String = "",
    var topicos: List<String> = listOf()
)

class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Conteúdo ${conteudo.nome} adicionado à formação $nome.")
    }

    fun listarConteudos() {
        println("Conteúdos da formação $nome:")
        conteudos.forEach { println("- ${it.nome}") }
    }

    fun listarInscritos() {
        println("Inscritos na formação $nome:")
        inscritos.forEach { println("- ${it.nome}") }
    }
}

fun main() {
    val usuario1 = Usuario("Bentinho")
    val usuario2 = Usuario("Capitu")

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 120)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 90)

    val formacao = Formacao("Desenvolvimento Kotlin")

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.adicionarConteudo(conteudo1)
    formacao.adicionarConteudo(conteudo2)

    formacao.listarConteudos()
    formacao.listarInscritos()
}