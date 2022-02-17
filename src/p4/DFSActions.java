package p4;

public interface DFSActions {
    void processVertex(Vertex v);

    void descend();

    void ascend();

    void cycleDetected();
}