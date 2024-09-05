import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ciudadNocturna extends JFrame {

    private Image carro;

    public ciudadNocturna() {
        setSize(800, 600);
        setTitle("Ciudad Nocturna");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        carro = new ImageIcon("src/imagenes/carrito.png").getImage();  // Asegúrate de tener la imagen en esta ruta

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        drawShapes(g);
    }

    public void drawShapes(Graphics g) {
        Graphics2D gg = (Graphics2D) g;

        // Fondo con degradado lineal
        GradientPaint gp = new GradientPaint(0, 0, Color.BLUE, 0, getHeight(), Color.BLACK, true);
        gg.setPaint(gp);
        gg.fillRect(0, 0, getWidth(), getHeight());

        try {
            BufferedImage ladrilloImage = ImageIO.read(getClass().getResource("imagenes/ladrillo.png"));
            TexturePaint texturaLadrillo = new TexturePaint(ladrilloImage, new Rectangle(0, 0, 50, 50));
            BufferedImage ladrillo2Image = ImageIO.read(getClass().getResource("imagenes/ladrillo2.png"));
            TexturePaint texturaLadrillo2 = new TexturePaint(ladrillo2Image, new Rectangle(0, 0, 50, 50));

            // Edificio 1
            gg.setPaint(texturaLadrillo);
            gg.fillRect(50, 300, 100, 250);

            // Edificio 2
            gg.setPaint(texturaLadrillo2);
            gg.fillRect(200, 250, 120, 300);

            // Edificio 3
            gg.setPaint(texturaLadrillo);
            gg.fillRect(370, 280, 150, 270);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ventanas de los edificios
        gg.setColor(Color.YELLOW);
        int ventanaSize = 20;
        int ventanaSpacing = 30;

        // Edificio 1
        int x = 60;
        int y = 310;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                gg.fillRect(x + j * ventanaSpacing, y + i * ventanaSpacing, ventanaSize, ventanaSize);
            }
        }

        // Edificio 2
        x = 210;
        y = 260;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                gg.fillRect(x + j * ventanaSpacing, y + i * ventanaSpacing, ventanaSize, ventanaSize);
            }
        }

        // Edificio 3
        x = 380;
        y = 290;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                gg.fillRect(x + j * ventanaSpacing, y + i * ventanaSpacing, ventanaSize, ventanaSize);
            }
        }

        // Luna con degradado radial
        gg.setColor(Color.LIGHT_GRAY);
        gg.fillOval(600, 50, 100, 100);
        Point2D centro = new Point2D.Float(650, 100);
        float radio = 50;
        float[] distribucionColor = {0.0f, 0.5f, 1.0f};
        Color[] colores = {Color.WHITE, Color.LIGHT_GRAY, Color.DARK_GRAY};
        RadialGradientPaint degradadoLuna = new RadialGradientPaint(centro, radio, distribucionColor, colores);
        gg.setPaint(degradadoLuna);
        gg.fillOval(600, 50, 100, 100);

        // Camino
        try {
            BufferedImage piedraImage = ImageIO.read(getClass().getResource("imagenes/piedra.png"));
            TexturePaint texturaPiedra = new TexturePaint(piedraImage, new Rectangle(0, 0, 100, 100));
            gg.setPaint(texturaPiedra);
            gg.fillRect(0, 550, 800, 50);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Estrellas
        gg.setColor(Color.WHITE);
        gg.fillOval(100, 100, 5, 5);
        gg.fillOval(150, 150, 5, 5);
        gg.fillOval(200, 50, 5, 5);
        gg.fillOval(300, 80, 5, 5);
        gg.fillOval(400, 120, 5, 5);
        gg.fillOval(500, 200, 5, 5);
        gg.fillOval(600, 50, 5, 5);

        // Batman
        gg.setColor(Color.BLACK);
        gg.fillOval(480, 180, 40, 40);
        gg.fillArc(460, 185, 80, 70, 0, -180);

        Polygon orejaIzquierda = new Polygon();
        orejaIzquierda.addPoint(487, 160);
        orejaIzquierda.addPoint(482, 190);
        orejaIzquierda.addPoint(497, 180);
        Polygon orejaDerecha = new Polygon();
        orejaDerecha.addPoint(507, 160);
        orejaDerecha.addPoint(502, 180);
        orejaDerecha.addPoint(517, 190);
        gg.fillPolygon(orejaIzquierda);
        gg.fillPolygon(orejaDerecha);

        gg.setColor(Color.DARK_GRAY);
        gg.fillRect(485, 220, 30, 50);
        gg.fillRect(485, 260, 10, 20);
        gg.fillRect(505, 260, 10, 20);

        gg.setColor(Color.WHITE);
        gg.fillOval(495, 190, 8, 8); // Ojo izquierdo
        gg.fillOval(510, 190, 8, 8); // Ojo derecho

        // Poste de luz
        gg.setColor(Color.GRAY);
        gg.fillRect(705, 470, 10, 90);
        gg.setColor(Color.DARK_GRAY);
        gg.fillRect(700, 560, 20, 10);
        gg.setColor(Color.YELLOW);
        gg.fillOval(695, 440, 30, 30);

        //Batimovil
        if (carro != null) {
            gg.drawImage(carro, 525, 500, 150, 70, this);
        } else {
            gg.setColor(Color.RED);
            gg.drawString("Imagen del carro no encontrada", 200, 500);
        }
    }
}


