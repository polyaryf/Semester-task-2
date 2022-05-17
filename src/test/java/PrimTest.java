import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimTest {
    static final int[][]  G = {
        { 0, 7, 8, 0, 0, 0 },
        { 7, 0, 11, 2, 0, 0 },
        { 8, 11, 0, 6, 9, 0 },
        { 0, 2, 6, 0, 11, 9 },
        { 0, 0, 9, 11, 0, 10 },
        { 0, 0, 0, 9, 10, 0 }
    };
    static final int V = 6;
    static final PrimGraph g = new PrimGraph();
    
    @Test
    void testPrim(){
        int weight = g.Prim(G,V);
        Assertions.assertEquals(33, weight);
    }

}
