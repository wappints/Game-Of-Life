package sample;

import java.util.ArrayList;

abstract public class Path {
    protected String name;
    protected ArrayList<Space> spaces = new ArrayList<Space>();
    Path() { }

    public void setPath(String name) {this.name = name; }
    public String getPath() { return name; }
    public ArrayList<Space> getFullPath() { return spaces; }

}
