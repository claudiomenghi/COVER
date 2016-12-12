package MTSAEnactment.ar.uba.dc.lafhis.enactment.robot;

import MTSAEnactment.ar.uba.dc.lafhis.enactment.TransitionEvent;

import javax.imageio.ImageIO;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * Created by lnahabedian on 18/07/16.
 */
public class ProductionCellEnvironmentSimulation<State, Action> extends
        RobotAdapter<State, Action> {

    public static String IMAGE_PATH = System.getProperty("user.dir") + "/src/main/resources/ProductionCellUpdateImg/";
    // controllable
    protected Action gPaint1, gPaint2;
    protected Action drill1, drill2;
    protected Action dry1, dry2;
    protected Action out1, out2;
    // uncontrollable
    protected Action in1, in2;
    protected Action drillOk1, drillOk2;
    protected Action drillNOk1, drillNOk2;
    protected Action gPaintOk1, gPaintOk2;
    protected Action gPaintNOk1, gPaintNOk2;
    protected Action dryOk1, dryOk2;
    protected Action dryNOk1, dryNOk2;
    protected Action reset1, reset2;
    // new controllable
    protected Action mPaint1, mPaint2;
    protected Action varnish1, varnish2;
    // new uncontrollable
    protected Action mPaintOk1, mPaintOk2;
    protected Action mPaintNOk1, mPaintNOk2;
    protected Action varnishOk1, varnishOk2;
    protected Action varnishNOk1, varnishNOk2;

    private ProductionCellEnvironmentUI simulationWindow;
    private int statusLine1;
    private int statusLine2;


    public ProductionCellEnvironmentSimulation(String name, Action success, Action failure, Action lost, Action gPaint1, Action gPaint2, Action drill1, Action drill2, Action dry1, Action dry2, Action out1, Action out2, Action in1, Action in2, Action drillOk1, Action drillOk2, Action drillNOk1, Action drillNOk2, Action gPaintOk1, Action gPaintOk2, Action gPaintNOk1, Action gPaintNOk2, Action dryOk1, Action dryOk2, Action dryNOk1, Action dryNOk2, Action reset1, Action reset2, Action mPaint1, Action mPaint2, Action varnish1, Action varnish2, Action mPaintOk1, Action mPaintOk2, Action mPaintNOk1, Action mPaintNOk2, Action varnishOk1, Action varnishOk2, Action varnishNOk1, Action varnishNOk2) {
        super(name, success, failure, lost);
        this.gPaint1 = gPaint1;
        this.gPaint2 = gPaint2;
        this.drill1 = drill1;
        this.drill2 = drill2;
        this.dry1 = dry1;
        this.dry2 = dry2;
        this.out1 = out1;
        this.out2 = out2;
        this.in1 = in1;
        this.in2 = in2;
        this.drillOk1 = drillOk1;
        this.drillOk2 = drillOk2;
        this.drillNOk1 = drillNOk1;
        this.drillNOk2 = drillNOk2;
        this.gPaintOk1 = gPaintOk1;
        this.gPaintOk2 = gPaintOk2;
        this.gPaintNOk1 = gPaintNOk1;
        this.gPaintNOk2 = gPaintNOk2;
        this.dryOk1 = dryOk1;
        this.dryOk2 = dryOk2;
        this.dryNOk1 = dryNOk1;
        this.dryNOk2 = dryNOk2;
        this.reset1 = reset1;
        this.reset2 = reset2;
        this.mPaint1 = mPaint1;
        this.mPaint2 = mPaint2;
        this.varnish1 = varnish1;
        this.varnish2 = varnish2;
        this.mPaintOk1 = mPaintOk1;
        this.mPaintOk2 = mPaintOk2;
        this.mPaintNOk1 = mPaintNOk1;
        this.mPaintNOk2 = mPaintNOk2;
        this.varnishOk1 = varnishOk1;
        this.varnishOk2 = varnishOk2;
        this.varnishNOk1 = varnishNOk1;
        this.varnishNOk2 = varnishNOk2;

        this.statusLine1 = 0;
        this.statusLine2 = 0;
    }

    @Override
    protected void primitiveHandleTransitionEvent(TransitionEvent<Action> transitionEvent) throws Exception {

        if (transitionEvent.getAction().equals(in1)) {
            downArm(1);
            inImageAt(1);
            statusLine1 = 1;
        } else if (transitionEvent.getAction().equals(in2)) {
            downArm(2);
            inImageAt(2);
            statusLine2 = 1;
        } else if (transitionEvent.getAction().equals(drillOk1)) {
            downArm(1);
            statusLine1 = drillImageAt(1, statusLine1);
        } else if (transitionEvent.getAction().equals(drillOk2)) {
            downArm(2);
            statusLine2 = drillImageAt(2, statusLine2);
        } else if (transitionEvent.getAction().equals(gPaintOk1)) {
            downArm(1);
            statusLine1 = gPaintImageAt(1, statusLine1);
        } else if (transitionEvent.getAction().equals(gPaintOk2)) {
            downArm(2);
            statusLine2 = gPaintImageAt(2, statusLine2);
        } else if (transitionEvent.getAction().equals(dryOk1)) {
            downArm(1);
            statusLine1 = dryImageAt(1, statusLine1);
        } else if (transitionEvent.getAction().equals(dryOk2)) {
            downArm(2);
            statusLine2 = dryImageAt(2, statusLine2);
        } else if (transitionEvent.getAction().equals(mPaintOk1)) {
            downArm(1);
            statusLine1 = mPaintImageAt(1, statusLine1);
        } else if (transitionEvent.getAction().equals(mPaintOk2)) {
            downArm(2);
            statusLine2 = mPaintImageAt(2, statusLine2);
        } else if (transitionEvent.getAction().equals(varnishOk1)) {
            downArm(1);
            statusLine1 = varnishImageAt(1, statusLine1);
        } else if (transitionEvent.getAction().equals(varnishOk2)) {
            downArm(2);
            statusLine2 = varnishImageAt(2, statusLine2);
        } else if (transitionEvent.getAction().equals(out1)) {
            downArm(1);
            outImageAt(1);
        } else if (transitionEvent.getAction().equals(out2)) {
            downArm(2);
            outImageAt(2);
        } else if (transitionEvent.getAction().equals(reset1)) {
            resetImageAt(1);
            statusLine1 = 0;
        } else if (transitionEvent.getAction().equals(reset2)) {
            resetImageAt(2);
            statusLine2 = 0;
        } else if (isAnArm1Action(transitionEvent.getAction())) {
            upArm(1);
        } else if (isAnArm2Action(transitionEvent.getAction())) {
            upArm(2);
        } else if (isNotOkArm1(transitionEvent.getAction())) {
            failArm(1);
        } else if (isNotOkArm2(transitionEvent.getAction())) {
            failArm(2);
        }

        simulationWindow.revalidate();
        simulationWindow.repaint();

    }

    private void failArm(int line) {

        simulationWindow.failArm(line);
    }

    private void downArm(int line) {

        simulationWindow.downArm(line);

    }

    private void upArm(int line) {

        simulationWindow.upArm(line);

    }

    private boolean isNotOkArm1(Action action) {

        return action.equals(drillNOk1) || action.equals(dryNOk1) ||
                action.equals(mPaintNOk1) || action.equals(gPaintNOk1) ||
                action.equals(varnishNOk1);
    }

    private boolean isNotOkArm2(Action action) {

        return action.equals(drillNOk2) || action.equals(dryNOk2) ||
                action.equals(mPaintNOk2) || action.equals(gPaintNOk2) ||
                action.equals(varnishNOk2);
    }

    private boolean isAnArm1Action(Action action) {

        return action.equals(drill1) || action.equals(dry1) ||
                action.equals(mPaint1) || action.equals(gPaint1) ||
                action.equals(varnish1);

    }

    private boolean isAnArm2Action(Action action) {

        return action.equals(drill2) || action.equals(dry2) ||
                action.equals(mPaint2) || action.equals(gPaint2) ||
                action.equals(varnish2);

    }

    private void inImageAt(int line) {

        BufferedImage image = loadImage("carRaw.png");
        simulationWindow.setProductImage(line, image);
    }

    private int gPaintImageAt(int line, int status) {

        BufferedImage image = null;
        int newStatus = 99999;

        if (status == 1) { // car is raw
            image = loadImage("GlossyCar.png");
            newStatus = 6;
        } else if (status == 2) { // DrilledCar
            image = loadImage("DrilledGlossyCar.png");
            newStatus = 4;
        } else {
            return status;
        }

        setProductImage(line, image);
        return newStatus;
    }

    private int mPaintImageAt(int line, int status) {

        BufferedImage image = null;
        int newStatus = 99999;

        if (status == 1) { // car is raw
            image = loadImage("MattedCar.png");
            newStatus = 8;
        } else if (status == 2) { // DrilledCar
            image = loadImage("DrilledMattedCar.png");
            newStatus = 3;
        } else {
            return status;
        }

        setProductImage(line, image);
        return newStatus;
    }

    private int dryImageAt(int line, int status) {

        BufferedImage image = null;
        int newStatus = 99999;

        if (status == 3) { // DrilledMattedCar
            image = loadImage("DrilledDriedMattedCar.png");
            newStatus = 10;
        } else if (status == 4) { // DrilledGlossyCar
            image = loadImage("FinishedCar.png");
            newStatus = 5;
        } else if (status == 6) { // GlossyCar
            image = loadImage("GlossyDriedCar.png");
            newStatus = 7;
        } else if (status == 8) { // MattedCar
            image = loadImage("MattedDriedCar.png");
            newStatus = 9;
        } else {
            return status;
        }

        setProductImage(line, image);
        return newStatus;
    }

    private int drillImageAt(int line, int status) {

        BufferedImage image = null;
        int newStatus = 99999;

        if (status == 1) { // car is raw
            image = loadImage("carDrilled.png");
            newStatus = 2;
        } else if (status == 6) { // glossyCar
            image = loadImage("DrilledGlossyCar.png");
            newStatus = 4;
        } else if (status == 7) { // glossyDriedCar
            image = loadImage("FinishedCar.png");
            newStatus = 5;
        } else if (status == 8) { // mattedCar
            image = loadImage("DrilledMattedCar.png");
            newStatus = 3;
        } else if (status == 9) { // mattedDriedCar
            image = loadImage("DrilledDriedMattedCar.png");
            newStatus = 10;
        } else {
            return status;
        }

        setProductImage(line, image);
        return newStatus;
    }

    private int varnishImageAt(int line, int status) {

        BufferedImage image = null;
        int newStatus = 99999;

        if (status == 3) { // DrilledMattedCar
            image = loadImage("DrilledGlossyCar.png");
            newStatus = 4;
        } else if (status == 8) { // MattedCar
            image = loadImage("GlossyCar.png");
            newStatus = 6;
        } else if (status == 9) { // MattedDriedCar
            image = loadImage("GlossyDriedCar.png");
            newStatus = 7;
        } else if (status == 10) { // DrilledDriedMattedCar
            image = loadImage("FinishedCar.png");
            newStatus = 5;
        } else {
            return status;
        }

        setProductImage(line, image);
        return newStatus;
    }

    private void outImageAt(int line) {
        BufferedImage image = loadImage("OutCar.png");
        setProductImage(line, image);
    }

    private void resetImageAt(int line) {

        simulationWindow.removeProduct(line);

    }

    @Override
    public void setUp() {
        System.out.println("SET UP");

        simulationWindow = new ProductionCellEnvironmentUI("ProductionCell Environment");

    }



    private void setProductImage(int line, BufferedImage image) {

        simulationWindow.setProductImage(line, image);

    }

    private BufferedImage loadImage(String filename) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(ProductionCellEnvironmentSimulation.IMAGE_PATH + filename));
        } catch (IOException ex) {
            System.out.println("Image " + filename + " not found");
        }
        return image;
    }

    @Override
    public void tearDown() {
        System.out.println("TEAR DOWN");
        simulationWindow.dispatchEvent(new WindowEvent(simulationWindow, WindowEvent.WINDOW_CLOSING));

    }
}





