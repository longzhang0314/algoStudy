package two.week09.graph.exercise;

/**
 * @author 流沙
 * @date 2023/9/4
 */
public class Exercise02Test2 {

    //image = [[1,1,1],[1,1,0],[1,0,1]]
    //sr = 1, sc = 1, newColor = 2
    //输出：[[2,2,2],[2,2,0],[2,0,1]]

    // 1 1 1
    // 1 1 0
    // 1 0 1

    // 2 2 2
    // 2 2 0
    // 2 0 1
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) return image;
        boolean[][] visited = new boolean[image.length][image[0].length];
        process(image, visited, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private void process(int[][] image, boolean[][] visited, int i, int j, int newColor, int model) {
        if (!isValid(image, visited, i, j, model)) {
            return;
        }
        visited[i][j] = true;
        image[i][j] = newColor;
        for (int[] direction : directions) {
            process(image, visited, i + direction[0], j + direction[1], newColor, model);
        }
    }

    private boolean isValid(int[][] image, boolean[][] visited, int i, int j, int model) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || visited[i][j] || image[i][j] != model) return false;
        return true;

    }
}
