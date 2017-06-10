/**
 * Created by kuzuyayuudai on 2017/06/10.
 */
public class SearchResult {

    private boolean foundFlag;
    private int foundElement;
    private int foundIndex;

    public SearchResult() {
        foundFlag = false;
        foundElement = -1;
        foundIndex = -1;
    }

    public SearchResult(boolean foundFlag, int foundElement, int foundIndex) {
        this.foundFlag = foundFlag;
        this.foundElement = foundElement;
        this.foundIndex = foundIndex;
    }

    public void setFoundFlag(boolean foundFlag) {
        this.foundFlag = foundFlag;
    }

    public void setFoundElement(int foundElement) {
        this.foundElement = foundElement;
    }

    public void setFoundIndex(int foundIndex) {
        this.foundIndex = foundIndex;
    }

    public boolean isFoundFlag() {
        return foundFlag;
    }

    public int getFoundElement() {
        return foundElement;
    }

    public int getFoundIndex() {
        return foundIndex;
    }

    public void printSerchResult() {
        if (foundFlag == true) {
            System.out.println("-> Target is found."
                    + "\n-> TargetIndex is " + foundIndex
                    + ".\n-> Target is " + foundElement + "."
            );
        }else{
            System.out.println("-> Target is not found.");
        }

    }


}
