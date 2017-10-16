package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {

    private Color colorFromColorPicker;
    private Color colorFromSliders;

    // Herunder udnyttes en funktion som kører ved opstart, heri kaldes en reset-funktionen.
    public void initialize(){
        reset();
    }

    // Herunder ses mine tre color-sliders som har et min: 0 & max: 255:
    @FXML public Slider redSlider;
    @FXML public Slider greenSlider;
    @FXML public Slider blueSlider;

    public void setRedSlider(){
        redSlider.getValue();
    }
    public void setGreenSlider(){
        System.out.println("greenSlider.. " + (int) greenSlider.getValue());
    }
    public void setBlueSlider(){
        System.out.println("blueSlider.. " + (int) blueSlider.getValue());
    }

    // Herunder ses min color-picker logik som fører sine variabler ind i mine sliders.
    @FXML public ColorPicker colorPicker;

    public void getColorFromPicker() {
        colorFromColorPicker = colorPicker.getValue();
        redSlider.setValue(colorFromColorPicker.getRed()*255);
        greenSlider.setValue(colorFromColorPicker.getGreen()*255);
        blueSlider.setValue(colorFromColorPicker.getBlue()*255);
        System.out.println("ColorPickers RGB = " + colorFromColorPicker.getRed()*255 + " " + colorFromColorPicker.getGreen()*255 + " " + colorFromColorPicker.getBlue()*255); // TODO: Slet (er til test)
        System.out.println("Colorpickers colorPickcerValue = " + colorFromColorPicker);
    }

    // Herunder defineres størrelses-slideren og de faste størrelser bestemmes til menuen:
    @FXML public Slider sizeSlider;
    public void setSizeSlider(){
        System.out.println("sizeSlider.. " +(int) sizeSlider.getValue());
    }

    public void setSize10(){
        sizeSlider.setValue(10);
    }
    public void setSize20(){
        sizeSlider.setValue(20);
    }
    public void setSize30(){
        sizeSlider.setValue(30);
    }
    public void setSize40(){
        sizeSlider.setValue(40);
    }
    public void setSize50(){
        sizeSlider.setValue(50);
    }
    public void setSize60(){
        sizeSlider.setValue(60);
    }
    public void setSize70(){
        sizeSlider.setValue(70);
    }
    public void setSize80(){
        sizeSlider.setValue(80);
    }
    public void setSize90(){
        sizeSlider.setValue(90);
    }
    public void setSize100(){sizeSlider.setValue(100);}
    public void setSize110() {sizeSlider.setValue(110);}

    // Herunder ses logik til at skifte farve på tegneren:
    @FXML public Canvas myCanvas;

    public void calcColor() {
        colorFromSliders = Color.rgb((int) redSlider.getValue(), (int) greenSlider.getValue(), (int) blueSlider.getValue());
    }

    public void setDrawingColor(MouseEvent mouseEvent){
        GraphicsContext gc = myCanvas.getGraphicsContext2D();
        calcColor();
        gc.setFill(colorFromSliders);
        gc.fillOval(mouseEvent.getX(), mouseEvent.getY(), sizeSlider.getValue(), sizeSlider.getValue());
        System.out.println(colorFromSliders); // TODO: Slet denne command - det er blot til test
    }


    //Herunder ses min reset funktion:
    public void reset() {
        GraphicsContext gc = myCanvas.getGraphicsContext2D();

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
        redSlider.setValue(0);
        greenSlider.setValue(0);
        blueSlider.setValue(0);
        sizeSlider.setValue(0);
    }


}
