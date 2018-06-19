import schoolGameFramework.Alternative;
import schoolGameFramework.GameWindow;
import schoolGameFramework.LevelQuestion;
import schoolGameFramework.LevelStateMachine;
import schoolGameFramework.Question;
import schoolGameFramework.ResultScene;
import schoolGameFramework.Score;
import schoolGameFramework.ScoreScreen;

public class Main {

	public static void main(String[] args) {

		//Instanciando a tela onde o jogo vai rodar
		GameWindow gameWindow = new GameWindow(800, 600);
		
		//Instanciando a maquina de estados resposavel por controlar o fluxo das telas
		LevelStateMachine levelStateMachine = new LevelStateMachine();
		
		
		//Instanciando a tela responsavel por mostrar as questoes
		LevelQuestion questionScreen = new LevelQuestion(gameWindow, "QuestionTeste");
		questionScreen.setBackground("src//img//lousa.jpeg"); //Adicionando background a tela de questoes
		questionScreen.setArrowImage("src//img//arrow_button.png"); //Adicionando a seta de selecao das alternativas 
		
		//Instanciando a questao 1
		Question teste1 = new Question("Esta eh a questao 1");
		
		
		//Toda questao possui, necessariamente, 4 alternativas
		//Instanciando alternativas
		Alternative testeA1 = new Alternative(1,"Texto alternativa a1",true);
		Alternative testeB1 = new Alternative(2,"Texto alternativa b1",false);
		Alternative testeC1 = new Alternative(3,"Texto alternativa c1",false);
		Alternative testeD1 = new Alternative(4,"Texto alternativa d1",false);

		//Adicionando as alternativas no arraylist presente em questoes
		teste1.addAlternative(testeA1);
		teste1.addAlternative(testeB1);
		teste1.addAlternative(testeC1);
		teste1.addAlternative(testeD1);

		//Toda tela de questao necessita, necessariamente, de 3 questoes
		//Abaixo desta linha de codigo estao as outras 2 questoes
		//O processo se repete para as proximas 2 questoes
		Question teste2 = new Question("Esta eh a questao 2");
		
		Alternative testeA2 = new Alternative(1,"Texto alternativa a2",false);
		Alternative testeB2 = new Alternative(2,"Texto alternativa b2",false);
		Alternative testeC2 = new Alternative(3,"Texto alternativa c2",true);
		Alternative testeD2 = new Alternative(4,"Texto alternativa d2",false);


		teste2.addAlternative(testeA2);
		teste2.addAlternative(testeB2);
		teste2.addAlternative(testeC2);
		teste2.addAlternative(testeD2);
		
		Question teste3 = new Question("Esta eh a questao 3");
		
		Alternative testeA3 = new Alternative(1,"Texto alternativa a3",false);
		Alternative testeB3 = new Alternative(2,"Texto alternativa b3",false);
		Alternative testeC3 = new Alternative(3,"Texto alternativa c3",false);
		Alternative testeD3 = new Alternative(4,"Texto alternativa c4",true);


		teste3.addAlternative(testeA3);
		teste3.addAlternative(testeB3);
		teste3.addAlternative(testeC3);
		teste3.addAlternative(testeD3);
		
		
		//Apos as questoes criadas e preenchidas pelas alternativas
		//Elas sao adicionadas a tela de questoes
		questionScreen.addQuestion(teste1);
		questionScreen.addQuestion(teste2);
		questionScreen.addQuestion(teste3);
		
		
		//Instanciando o singleton resposavel por printar o resultado
		ResultScene result = ResultScene.getResultInstance(gameWindow, false);
		result.setBackground("src//img//lousa.jpeg"); //Adicionando background em result screen
		
		//Instanciando o singleton responsavel por printar o score (apos aparecerem as 3 questoes)
		ScoreScreen score = ScoreScreen.getScoreScreenInstance(gameWindow);
		score.setBackground("src//img//lousa.jpeg");//Setando o background da score screen
		
		//A tela de score necessita de ser preenchida por 4 niveis de pontuacao
		//Abaixo se preenche o array list com os 4 niveis de pontuacao
		Score testScore = new Score();
		testScore.addScoreType("Nota == Nivel 0");
		testScore.addScoreType("Nota == Nivel 1");
		testScore.addScoreType("Nota == Nivel 2");
		testScore.addScoreType("Nota == Nivel 3");
		
		
		//Adiciona-se o array de score dentro da score screen
		ScoreScreen.addScore(testScore);
		
		//A tela de resultado necessita saber qual e a tela de questoes pra qual ela volta
		//E apos passar pelas 3 questoes da tela de questoes ela precisa saber pra qual tela de score deve ir
		//Logo isso deve ser setado, por exemplo:
		ResultScene.setQuestionScenario("QuestionTeste");
		ResultScene.setScoreScenario("ScoreScreen");
		
		//Como opcional o usuario pode alterar os textos de resposta certa ou errada
		//da result scene
		ResultScene.setCorrectAnswerMessage("Texto de acerto 'VOCE ACERTOU!'");
		ResultScene.setWrongMessage("Texto de Errro 'VOCE ERROU!'");
		
		
		//Apos a instanciacao de todas as telas criadas elas sao adicionanadas
		//levelstatemachine onde passarao pelo fluxo
		//questao1 -> resultado1 -> questao2 -> resultado2 -> questao3 -> resultado3 -> pontuacao final
		levelStateMachine.addScenario(questionScreen);
		levelStateMachine.addScenario(result);
		levelStateMachine.addScenario(score);
		
		//Inicia-se o jogo da tela de questoes com a questao 1
		levelStateMachine.run("QuestionTeste");
		
	}

}
