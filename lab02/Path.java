/** A class that represents a path via pursuit curves. */
public class Path {

    // TODO
    public Point curr;
    public Point next;

    public Path(double x, double y)
    {
        next = new Point (x, y)
        curr = new Point (1, 1)
    }
    public double getCurrX()
    {
      return this.curr.getX();
    }
    public double getCurrY()
    {
      return this.curr.getY();
    }
    public double getNextX()
    {
      return this.next.getX()
    }
    public double getNextY()
    {
      return this.next.getY();
    }
    public void Point point)
    {
      curr = point;
    }
    public void iterate(double dx, double dy)
    {
      curr.setX(next.getX());
      curr.setY(next.getY());
      next.setX(next.getX() + dx);
      next.setY(next.getY() + dy);
    }
}
