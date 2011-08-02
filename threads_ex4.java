final Handler handler = new Handler(){
	@Override
	public void handleMessage(android.os.Message msg) {
		super.handleMessage(msg);
		Bitmap b = (Bitmap)msg.getData().getParcelable("myImage");
		mImageView.setImageBitmap(b);
	}
};

public void onClick(View v) {
	new Thread(new Runnable() {
		public void run() {
        	final Bitmap b = loadImageFromNetwork();
      		Bundle data = new Bundle();
	  		data.putParcelable("myImage", b);
	  		android.os.Message handlerMsg = handler.obtainMessage();
	  		handlerMsg.setData(data);
	  		handler.sendMessage(handlerMsg);
    	}
	}).start();
}