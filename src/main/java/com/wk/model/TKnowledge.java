package com.wk.model;

public class TKnowledge {
    private Integer id;

    private String question1;

    private String question2;

    private String question3;

    private String question4;

    private String question5;

    private String question6;

    private String answer;

    private Integer useNum;

    private Integer solveNum;

    private Integer unsolveNum;

    public TKnowledge(Integer id, String question1, String question2, String question3, String question4, String question5, String question6, String answer, Integer useNum, Integer solveNum, Integer unsolveNum) {
        this.id = id;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.question4 = question4;
        this.question5 = question5;
        this.question6 = question6;
        this.answer = answer;
        this.useNum = useNum;
        this.solveNum = solveNum;
        this.unsolveNum = unsolveNum;
    }

    public TKnowledge() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1 == null ? null : question1.trim();
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2 == null ? null : question2.trim();
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3 == null ? null : question3.trim();
    }

    public String getQuestion4() {
        return question4;
    }

    public void setQuestion4(String question4) {
        this.question4 = question4 == null ? null : question4.trim();
    }

    public String getQuestion5() {
        return question5;
    }

    public void setQuestion5(String question5) {
        this.question5 = question5 == null ? null : question5.trim();
    }

    public String getQuestion6() {
        return question6;
    }

    public void setQuestion6(String question6) {
        this.question6 = question6 == null ? null : question6.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getUseNum() {
        return useNum;
    }

    public void setUseNum(Integer useNum) {
        this.useNum = useNum;
    }

    public Integer getSolveNum() {
        return solveNum;
    }

    public void setSolveNum(Integer solveNum) {
        this.solveNum = solveNum;
    }

    public Integer getUnsolveNum() {
        return unsolveNum;
    }

    public void setUnsolveNum(Integer unsolveNum) {
        this.unsolveNum = unsolveNum;
    }
}