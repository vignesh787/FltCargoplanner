package bits.dissertation.project.fltcargoplanner;

/**
 * Created by Vignesh on 9/5/2016.
 */
import android.util.Log;
import android.widget.ProgressBar;


public class FlightInfo {


    private final String mFlightdata; // XX- 2001 - FRA - SFO - 08/20/2013 10:00  - 08/20/2013 22:00
    private volatile Integer mProgress;
  //  private final Integer mFileSize;
    private volatile ProgressBar mProgressBar;

    public FlightInfo(String flightData, Integer progress) {
        mFlightdata = flightData;
        mProgress = progress;
    //    mFileSize = size;
        mProgressBar = null;
    }

    public ProgressBar getProgressBar() {
        return mProgressBar;
    }
    public void setProgressBar(ProgressBar progressBar) {

        mProgressBar = progressBar;
    }

    public Integer getProgress() {
        return mProgress;
    }

    public void setProgress(Integer progress) {
        this.mProgress = progress;
    }

  /*  public Integer getFileSize() {
        return mFileSize;
    }
*/
    public String getFlightData() {
        return mFlightdata;
    }
}
