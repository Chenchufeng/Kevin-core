package TemplateMethodPattern.StudyAbroad;

import java.io.FilterInputStream;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @Author: Kevin
 * @Date: 2021/8/16 22:58
 * @Description:
 * 【例1】用模板方法模式实现出国留学手续设计程序。
 *
 * 分析：出国留学手续一般经过以下流程：索取学校资料，提出入学申请，
 * 办理因私出国护照、出境卡和公证，申请签证，体检、订机票、准备行装，抵达目标学校等，
 * 其中有些业务对各个学校是一样的，但有些业务因学校不同而不同，所以比较适合用模板方法模式来实现。
 */
public class StudyAbroadProcess {
    public static void main(String[] args) {
    StudyAbroad studyAbroad=new StudyInAmerica();
    studyAbroad.TemplateMethod();
    }

}