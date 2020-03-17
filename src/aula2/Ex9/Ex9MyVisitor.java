package aula2.Ex9;


public class Ex9MyVisitor extends Ex9BaseVisitor<Object> {
    Question[] questions;

    @Override
    public Object visitProgram(Ex9Parser.ProgramContext ctx) {
        questions = new Question[ctx.question().size()];
        for (var i = 0; i < ctx.question().size(); i++) {
            questions[i] = (Question) visit(ctx.question(i));
        }
        return questions;
    }

    @Override
    public Object visitQuestion(Ex9Parser.QuestionContext ctx) {
        String question = ctx.text.getText().substring(1, ctx.text.getText().length() - 1);
        String id1 = ctx.id1.getText();
        String id2 = ctx.id2.getText();
        String[] answers = new String[ctx.opts().size()];
        Integer[] points = new Integer[ctx.opts().size()];
        for (int i = 0; i < ctx.opts().size(); i++) {
            AnswerAndPoints aap = (AnswerAndPoints) visit(ctx.opts(i));
            answers[i] = aap.answer;
            points[i] = aap.points;
        }
        return new Question(question, id1, id2, answers, points);
    }

    @Override
    public Object visitOpts(Ex9Parser.OptsContext ctx) {
        return new AnswerAndPoints(ctx.text.getText().substring(1, ctx.text.getText().length() - 1), Integer.parseInt(ctx.points.getText()));
    }

    class AnswerAndPoints {
        String answer;
        Integer points;

        public AnswerAndPoints(String answer, Integer points) {
            this.answer = answer;
            this.points = points;
        }
    }
}
