import javax.swing.*;
import java.awt.*;
import java.util.Random;

class RandomDrawing extends JPanel {

    private final int numShapes;
    private final int width;
    private final int height;

    public RandomDrawing(int numShapes, int width, int height) {
        this.numShapes = numShapes;
        this.width = width;
        this.height = height;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Random random = new Random();

        for (int i = 0; i < numShapes; i++) {
            int shapeType = random.nextInt(6); // 0-5: 0-line, 1-circle, 2-rectangle, 3-triangle, 4-parabola, 5-trapezoid

            int x = random.nextInt(width);
            int y = random.nextInt(height);

            int size = random.nextInt(50) + 10;

            switch (shapeType) {
                case 0:
                    g.drawLine(x, y, x + size, y + size);
                    break;
                case 1:
                    g.drawOval(x, y, size, size);
                    break;
                case 2:
                    g.drawRect(x, y, size, size);
                    break;
                case 3:
                    int[] xPoints = {x, x + size, x - size};
                    int[] yPoints = {y, y + size, y + size};
                    g.drawPolygon(xPoints, yPoints, 3);
                    break;
                case 4:
                    // Implement parabola drawing logic
                    break;
                case 5:
                    // Implement trapezoid drawing logic
                    break;
            }
        }

        // Draw coordinate grid
        g.setColor(Color.GRAY);
        for (int i = 0; i < width; i += 50) {
            g.drawLine(i, 0, i, height);
        }
        for (int i = 0; i < height; i += 50) {
            g.drawLine(0, i, width, i);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Random Drawing");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            int numShapes = 10; // Указать количество базовых фигур
            int width = 800; // Ширина области координат
            int height = 600; // Высота области координат

            RandomDrawing randomDrawing = new RandomDrawing(numShapes, width, height);
            frame.add(randomDrawing);

            frame.setVisible(true);
        });
    }
}