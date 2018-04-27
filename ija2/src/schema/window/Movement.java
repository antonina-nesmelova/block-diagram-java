

public class Movement extends JPanel implements MouseMotionListener, MouseListener { 
	private int X;
	private int Y;
	private int mouseX;
	private int mouseY;
	
	public Movement(Component... pns) {
    	for(Component frame : pns) {
    		frame.addMouseListener(this);
    		frame.addMouseMotionListener(this);
    	}
    }
    
    public void mouseMoved(MouseEvent evt) {
    
    }
    public void mouseDragged(MouseEvent evt) {
    	getCoordinates(evt);
        //evt.getComponent().setLocation((evt.getX()+evt.getComponent().getX())-X, (evt.getY()+evt.getComponent().getY())-Y);
    }

    private void getCoordinates(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getX();
        mouseY = mouseEvent.getY();
    }
    
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
