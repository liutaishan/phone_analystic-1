package com.phone.analystic.modle;

import com.phone.analystic.modle.base.BaseDimension;
import com.phone.analystic.modle.base.BrowserDimension;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

/**
 * @ClassName StatsUserDimension
 * @Author lyd
 * @Date $ $
 * @Vesion 1.0
 * @Description 可以用于用户模块和浏览器模块的map和reduce阶段输出的key的类型
 **/
public class StatsUserDimension extends StatsBaseDimension {
    private BrowserDimension browserDimension = new BrowserDimension();
    private StatsCommonDimension statsCommonDimension = new StatsCommonDimension();

    public StatsUserDimension(){}

    public StatsUserDimension(StatsCommonDimension statsCommonDimension, BrowserDimension browserDimension) {
        this.browserDimension = browserDimension;
        this.statsCommonDimension = statsCommonDimension;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        this.browserDimension.write(dataOutput);
        this.statsCommonDimension.write(dataOutput);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.browserDimension.readFields(dataInput);
        this.statsCommonDimension.readFields(dataInput);
    }


    /**
     * 克隆一个当前的新对象
     * @param dimension
     * @return
     */
    public static final StatsUserDimension clone(StatsUserDimension dimension){
          StatsCommonDimension statsCommonDimension = StatsCommonDimension.clone(dimension.statsCommonDimension);
          BrowserDimension browserDimension = new BrowserDimension(dimension.browserDimension.getBrowserName(),
                dimension.browserDimension.getBrowserVersion());
        return new StatsUserDimension(statsCommonDimension,browserDimension);
    }

    @Override
    public int compareTo(BaseDimension o) {
        if(this == o){
            return 0;
        }

        StatsUserDimension other = (StatsUserDimension) o;
        int tmp = this.browserDimension.compareTo(other.browserDimension);
        if(tmp != 0){
            return tmp;
        }
        return this.statsCommonDimension.compareTo(other.statsCommonDimension);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatsUserDimension that = (StatsUserDimension) o;
        return Objects.equals(statsCommonDimension, that.statsCommonDimension) &&
                Objects.equals(browserDimension, that.browserDimension);
    }

    @Override
    public int hashCode() {

        return Objects.hash(statsCommonDimension, browserDimension);
    }

    public StatsCommonDimension getStatsCommonDimension() {
        return statsCommonDimension;
    }

    public void setStatsCommonDimension(StatsCommonDimension statsCommonDimension) {
        this.statsCommonDimension = statsCommonDimension;
    }

    public BrowserDimension getBrowserDimension() {
        return browserDimension;
    }

    public void setBrowserDimension(BrowserDimension browserDimension) {
        this.browserDimension = browserDimension;
    }

    @Override
    public String toString() {
        return "StatsUserDimension{" +
                "browserDimension=" + browserDimension +
                ", statsCommonDimension=" + statsCommonDimension +
                '}';
    }
}