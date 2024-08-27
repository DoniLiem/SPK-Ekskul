
package KRITERIA;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class pembobotanAHP {

    private int n; // Jumlah kriteria
    private double[][] matrix;
    private double[] colSum;
    private double[][] normalizedMatrix;
    private double[] rowSum;
    private double[] priorityWeights;
    private double[] initialValues;
    
    // Konstruktor yang menerima nilai initialValues
    public pembobotanAHP(int n, double[] initialValues) {
        this.n = n;
        this.initialValues = initialValues;
        this.matrix = new double[n][n];
        this.colSum = new double[n];
        this.normalizedMatrix = new double[n][n];
        this.rowSum = new double[n];
        this.priorityWeights = new double[n];
        initializeMatrix();
    }
    
    // Setter untuk initialValues
    public void setInitialValues(double[] initialValues) {
        this.initialValues = initialValues;
        initializeMatrix(); // Reinitialize matrix with new initialValues
    }
    
    // Inisialisasi matriks AHP dengan nilai yang sudah ada
    private void initializeMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else if (i < j) {
                    matrix[i][j] = initialValues[j - i];
                } else {
                    matrix[i][j] = 1.0 / matrix[j][i];
                }
                matrix[i][j] = round(matrix[i][j], 2);
            }
        }
    }
    
    // Menampilkan matriks
    public void printMatrix(double[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%.2f ", matrix[i][j]);
            }
            System.out.println();
        }
    }
    
    // Menghitung jumlah setiap kolom
    public void sumColumns() {
        for (int j = 0; j < n; j++) {
            colSum[j] = 0;
            for (int i = 0; i < n; i++) {
                colSum[i] = round(colSum[i], 2);
                colSum[j] += matrix[i][j];
            }
        }
    }
    
    // Menormalisasi matriks
    public void normalizeMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                normalizedMatrix[i][j] = matrix[i][j] / colSum[j];
                normalizedMatrix[i][j] = round(normalizedMatrix[i][j], 2);
            }
        }
    }
    
    // Menghitung jumlah setiap baris
    public void sumRows() {
        for (int i = 0; i < n; i++) {
            rowSum[i] = 0;
            for (int j = 0; j < n; j++) {
                rowSum[i] = round(rowSum[i], 2);
                rowSum[i] += normalizedMatrix[i][j];
            }
            rowSum[i] = round(rowSum[i], 2);
        }
    }
    
    // Menghitung bobot prioritas
    public void calculatePriorityWeights() {
        double totalSum = 0;
        for (double sum : rowSum) {
            totalSum += sum;
        }
        for (int i = 0; i < n; i++) {
            priorityWeights[i] = rowSum[i] / totalSum;
            priorityWeights[i] = round(priorityWeights[i], 2);
        }
    }
    
    // Getter untuk matriks
    public double[][] getMatrix() {
        return matrix;
    }

    // Getter untuk matriks yang sudah dinormalisasi
    public double[][] getNormalizedMatrix() {
        return normalizedMatrix;
    }

    // Getter untuk bobot prioritas
    public double[] getPriorityWeights() {
        return priorityWeights;
    }
    
    // Getter untuk jumlah setiap kolom
    public double[] getColumnSums() {
        return colSum;
    }

    // Getter untuk jumlah setiap baris
    public double[] getRowSums() {
        return rowSum;
    }
    
    // Metode untuk membulatkan nilai
    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}


