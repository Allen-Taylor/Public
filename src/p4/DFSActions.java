package p4;

public interface DFSActions {
    void processVertex();

    void descendVertex();

    void ascendVertex();

    void cycleDetected();
}