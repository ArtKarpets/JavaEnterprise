package entity;

public class Quiz {

    private int questionNumber;
    private String question;
    private int answer;

    public Quiz() {
    }

    public Quiz(int questionNumber, String question, int answer) {
        this.questionNumber = questionNumber;
        this.question = question;
        this.answer = answer;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question " + questionNumber + ":" + question;

    }
}
