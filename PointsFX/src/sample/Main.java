package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ArrayList<XYChart.Series> lines = getLines();

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();

        final LineChart<Number,Number> lineChart = new LineChart<Number, Number>(xAxis,yAxis);

        /*for (XYChart.Series l : lines){
            XYChart.Series series = new XYChart.Series();
            for (Point p : l.getPoints()){
                series.getData().add(new XYChart.Data(p.getX(),p.getY()));
            }
            lines.add(series);
        }*/


        primaryStage.setTitle("Lines");
        for (XYChart.Series s : lines){
            lineChart.getData().add(s);
        }
        primaryStage.setScene(new Scene(lineChart, 800, 600));
        primaryStage.show();

    }

private static ArrayList<XYChart.Series> getLines() {
    ArrayList<Point> inputPoints = new ArrayList<>();
    ArrayList<Line> lines = new ArrayList<>();

    /*FileInputStream input;
    ArrayList<Integer> coors = new ArrayList<>();
    int j;
    try {
        input = new FileInputStream("input.txt");
        while ((j = input.read()) != -1){
            if (Character.isDigit((char)j)){
                coors.add(Integer.parseInt(String.valueOf((char)j)));
            }
            if ((char)j == '\n'){
                inputPoints.add(new Point(coors.get(0),coors.get(1)));
                coors.clear();
            }
        }
        inputPoints.add(new Point(coors.get(0),coors.get(1)));
    } catch (IOException ignored) {}*/
    /*inputPoints.add(new Point(1,1));
    inputPoints.add(new Point(9,6));
    inputPoints.add(new Point(5,5));
    inputPoints.add(new Point(4,1));
    inputPoints.add(new Point(2,4));
    inputPoints.add(new Point(2,2));
    inputPoints.add(new Point(4,3));
    inputPoints.add(new Point(3,6));
    inputPoints.add(new Point(8,4));*/

    inputPoints.add(new Point(5, 6));

    inputPoints.add(new Point(1, 1));
        inputPoints.add(new Point(2, 1));
        inputPoints.add(new Point(2, 3));
        inputPoints.add(new Point(3, 2));
        inputPoints.add(new Point(5, 1));
        inputPoints.add(new Point(1, 3));
        inputPoints.add(new Point(7, 1));
        inputPoints.add(new Point(7, 3));
        inputPoints.add(new Point(9, 3));
        inputPoints.add(new Point(4, 4));
        inputPoints.add(new Point(2, 6));
        inputPoints.add(new Point(1, 7));


   /* inputPoints.sort(new XComparator().thenComparing(new YComparator()));

    Line line = new Line();
    line.add(inputPoints.get(0));
    for (int i = 1; i < inputPoints.size(); i++){
        if (inputPoints.get(i).getX() >= inputPoints.get(i-1).getX() && inputPoints.get(i).getY() >= inputPoints.get(i-1).getY()){
            line.add(inputPoints.get(i));
        }else {
            lines.add(line);
            line = new Line();
            line.add(inputPoints.get(i));
        }
    }
    lines.add(line);*/

    inputPoints.sort(new XComparator());
    final NumberAxis xAxis = new NumberAxis();
    final NumberAxis yAxis = new NumberAxis();
    ArrayList<XYChart.Series> seriesList = new ArrayList<>();
    for (int i = 0; i < inputPoints.size();){
        Line line = new Line();
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data(inputPoints.get(i).getX(),inputPoints.get(i).getY()));
        line.add(inputPoints.get(0));
        inputPoints.remove(0);
        for (int j = 0; j < inputPoints.size(); j++)
        {
            if (line.getLastPoint().getY() <= inputPoints.get(j).getY() && line.getLastPoint().getX() <= inputPoints.get(j).getX()){
                line.add(inputPoints.get(j));
                series.getData().add(new XYChart.Data(inputPoints.get(j).getX(),inputPoints.get(j).getY()));
                inputPoints.remove(j);
                j--;
            }
        }
        seriesList.add(series);
    }

    return seriesList;
}


    public static void main(String[] args) {
        launch(args);
    }
}

