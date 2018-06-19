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

		GameWindow gameWindow = new GameWindow(800, 600);
		LevelStateMachine levelStateMachine = new LevelStateMachine();
		
		LevelQuestion questionScreen = new LevelQuestion(gameWindow, "QuestionTeste");
		questionScreen.setBackground("src//img//lousa.jpeg");
		questionScreen.setArrowImage("src//img//arrow_button.png");
		
		Question teste1 = new Question("Esta eh a questao 1");
		
		Alternative testeA1 = new Alternative(1,"Texto alternativa a1",true);
		Alternative testeB1 = new Alternative(2,"Texto alternativa b1",false);
		Alternative testeC1 = new Alternative(3,"Texto alternativa c1",false);
		Alternative testeD1 = new Alternative(4,"Texto alternativa d1",false);


		teste1.addAlternative(testeA1);
		teste1.addAlternative(testeB1);
		teste1.addAlternative(testeC1);
		teste1.addAlternative(testeD1);

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
		
		
		questionScreen.addQuestion(teste1);
		questionScreen.addQuestion(teste2);
		questionScreen.addQuestion(teste3);
		
		
		ResultScene result = ResultScene.getResultInstance(gameWindow, false);
		result.setBackground("src//img//lousa.jpeg");
		
		ScoreScreen score = ScoreScreen.getScoreScreenInstance(gameWindow);
		score.setBackground("src//img//lousa.jpeg");
		
		Score testScore = new Score();
		testScore.addScoreType("Nota == Nivel 0");
		testScore.addScoreType("Nota == Nivel 1");
		testScore.addScoreType("Nota == Nivel 2");
		testScore.addScoreType("Nota == Nivel 3");
		
		ScoreScreen.addScore(testScore);
		
		ResultScene.setQuestionScenario("QuestionTeste");
		ResultScene.setScoreScenario("ScoreScreen");
		ResultScene.setCorrectAnswerMessage("Texto de acerto 'VOCE ACERTOU!'");
		ResultScene.setWrongMessage("Texto de Errro 'VOCE ERROU!'");
		
		levelStateMachine.addScenario(questionScreen);
		levelStateMachine.addScenario(result);
		levelStateMachine.addScenario(score);
		
		levelStateMachine.run("QuestionTeste");
		
	}

}
