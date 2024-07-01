

import java.math.BigDecimal;
import java.util.*;

/**
 * @author liusha
 * @date 2022/9/9
 */
public class Test2 {

    public static void main(String[] args) {
        Long minPrice = 600000L;
        BigDecimal benchmarkPrice = new BigDecimal("626666.66666666");
        Long priceScore = 90L;
        Long quotationPrice = 650000L;
        List<BiddingScoreRequirement> biddingScoreRequirements = new ArrayList<>(1);
        BiddingScoreRequirement b = new BiddingScoreRequirement();
        b.setScoreOptionType(ScoreOptionTypeEnum.PRICE);
//        b.setDeviationHigh(new BigDecimal("0.01"));
//        b.setDeviationHighMinus(new BigDecimal("0.015"));
//        b.setDeviationLow(new BigDecimal("0.01"));
//        b.setDeviationLowMinus(new BigDecimal("0.01"));

//        b.setDeviationHigh(new BigDecimal("0.01"));
//        b.setDeviationHighMinus(new BigDecimal("0.015"));
//        b.setDeviationLow(new BigDecimal("0.01"));
//        b.setDeviationLowMinus(new BigDecimal("0.01"));
        b.setDeviationValue(new BigDecimal("0.43"));
        b.setDeviationValueMinus(new BigDecimal("1.222"));
        biddingScoreRequirements.add(b);
        Test2 d = new Test2();
        System.out.println(d.calculateFinalPriceScore(minPrice, benchmarkPrice, priceScore, quotationPrice, null, biddingScoreRequirements));

//        System.out.println(new BigDecimal("9.375").multiply(new BigDecimal(100)).multiply(new BigDecimal(0.015)));
//
//        System.out.println(new BigDecimal("9.375").multiply(new BigDecimal("0.015")).divide(new BigDecimal("0.01"), 3, BigDecimal.ROUND_HALF_UP));
    }

    /**
     * 倍数
     */
    public static final BigDecimal TIMES = new BigDecimal(1000);


    public Long calculateFinalPriceScore(Long minPrice, BigDecimal benchmarkPrice, Long priceScore, Long quotationPrice, String biddingRule,
                                         List<BiddingScoreRequirement> biddingScoreRequirements) {
        if (Objects.isNull(priceScore) || Objects.equals(priceScore, 0L)) {
            return 0L;
        }
        BiddingScoreRequirement biddingScoreRequirement = biddingScoreRequirements.stream()
                .filter(v -> Objects.equals(v.getScoreOptionType(), ScoreOptionTypeEnum.PRICE))
                .findFirst()
                .orElse(null);
        // 偏离率 =（投标报价-基准价）/ 基准价 * 100%
        BigDecimal deviationRatioValue = new BigDecimal(quotationPrice).subtract(benchmarkPrice);
        // 保留8位小数, 提高计算精度
        BigDecimal result = deviationRatioValue.divide(benchmarkPrice, 8, BigDecimal.ROUND_FLOOR).multiply(new BigDecimal(100));

        // 获取扣减分
        BigDecimal deductionValue = getDeductionValue(result, biddingScoreRequirement);
        // 从满分score开始扣减扣完为止，最小0分(四舍五入)
        BigDecimal resValue = new BigDecimal(priceScore).subtract(deductionValue).setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal finalValue = resValue.multiply(TIMES);
        return resValue.compareTo(BigDecimal.ZERO) < 0 ? 0L : finalValue.longValue();
    }

    /**
     * 获取默认扣减的分：无替换时走默认逻辑
     * <p>
     * <pre>
     * 注：因为评分保留三位小数，所以值都扩大1000倍
     * <li>投标报价的偏离率小于零(即投标报价小于基准价), 减(0.01 * 偏移率)分 (注: 0.01分);</li>
     * <li>投标报价的偏离率大于0(即投标报价高于基准价), 减(0.015 * 偏移率)分 (注: 0.015分).</li>
     * </pre>
     *
     * @param deviate                 偏离率
     * @param scoreRequirement
     * @return 扣减的分
     */
    private BigDecimal getDeductionValue(BigDecimal deviate, BiddingScoreRequirement scoreRequirement) {
        // 获取高值、低值及对应扣减分数
        BigDecimal deviationHigh = Objects.nonNull(scoreRequirement.getDeviationHigh())
                ? scoreRequirement.getDeviationHigh()
                : Objects.nonNull(scoreRequirement.getDeviationValue())
                ? scoreRequirement.getDeviationValue()
                : new BigDecimal("0.01");
        BigDecimal deviationHighMinus = Objects.nonNull(scoreRequirement.getDeviationHighMinus())
                ? scoreRequirement.getDeviationHighMinus()
                : Objects.nonNull(scoreRequirement.getDeviationValueMinus())
                ? scoreRequirement.getDeviationValueMinus()
                : new BigDecimal("0.015");
        BigDecimal deviationLow = Objects.nonNull(scoreRequirement.getDeviationLow())
                ? scoreRequirement.getDeviationLow()
                : Objects.nonNull(scoreRequirement.getDeviationValue())
                ? scoreRequirement.getDeviationValue()
                : new BigDecimal("0.01");
        BigDecimal deviationLowMinus = Objects.nonNull(scoreRequirement.getDeviationLowMinus())
                ? scoreRequirement.getDeviationLowMinus()
                : Objects.nonNull(scoreRequirement.getDeviationValueMinus())
                ? scoreRequirement.getDeviationValueMinus()
                : new BigDecimal("0.01");

//        BigDecimal highMulti = deviationHigh.multiply(deviationHighMinus).divide(new BigDecimal("0.01"), 8, BigDecimal.ROUND_FLOOR);
//        BigDecimal lowMulti = deviationLow.multiply(deviationLowMinus).divide(new BigDecimal("0.01"), 8, BigDecimal.ROUND_FLOOR);

        // 定义需要扣减的分数
        if (deviate.compareTo(BigDecimal.ZERO) < 0) {
            return deviate.multiply(deviationLowMinus).divide(deviationLow, 3, BigDecimal.ROUND_HALF_UP).negate();
        } else if (deviate.compareTo(BigDecimal.ZERO) > 0) {
            return deviate.multiply(deviationHighMinus).divide(deviationHigh, 3, BigDecimal.ROUND_HALF_UP);
        }
        return BigDecimal.ZERO;
    }










    public static enum ScoreOptionTypeEnum {
        PRICE("价格分"),
        TECHNICAL_SERVICE("技术服务分"),
        CREDIT("信用分"),
        PERFORMANCE("业绩分");

        private String desc;

        ScoreOptionTypeEnum(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }


    public static class BiddingScoreRequirement {
        private Long biddingOrderId;

        /**
         * 父评分规则id
         */
        private Long parentId;

        /**
         * 评分项描述
         */
        private String scoreOption;

        /**
         * 评分项
         */
        private ScoreOptionTypeEnum scoreOptionType;

        /**
         * 评分标准
         */
        private String scoreStandard;

        /**
         * 分数
         */
        private Long score;

        /**
         * 偏移率高值
         */
        private BigDecimal deviationHigh;

        /**
         * 偏移率高值减分
         */
        private BigDecimal deviationHighMinus;

        /**
         * 偏移率低值
         */
        private BigDecimal deviationLow;

        /**
         * 偏移率低值减分
         */
        private BigDecimal deviationLowMinus;

        /**
         * 偏移率值
         */
        private BigDecimal deviationValue;

        /**
         * 偏移率值减分
         */
        private BigDecimal deviationValueMinus;

        private List<BiddingScoreRequirement> biddingScoreRequirements;

        public Long getBiddingOrderId() {
            return biddingOrderId;
        }

        public void setBiddingOrderId(Long biddingOrderId) {
            this.biddingOrderId = biddingOrderId;
        }

        public Long getParentId() {
            return parentId;
        }

        public void setParentId(Long parentId) {
            this.parentId = parentId;
        }

        public String getScoreOption() {
            return scoreOption;
        }

        public void setScoreOption(String scoreOption) {
            this.scoreOption = scoreOption;
        }

        public ScoreOptionTypeEnum getScoreOptionType() {
            return scoreOptionType;
        }

        public void setScoreOptionType(ScoreOptionTypeEnum scoreOptionType) {
            this.scoreOptionType = scoreOptionType;
        }

        public String getScoreStandard() {
            return scoreStandard;
        }

        public void setScoreStandard(String scoreStandard) {
            this.scoreStandard = scoreStandard;
        }

        public Long getScore() {
            return score;
        }

        public void setScore(Long score) {
            this.score = score;
        }

        public BigDecimal getDeviationHigh() {
            return deviationHigh;
        }

        public void setDeviationHigh(BigDecimal deviationHigh) {
            this.deviationHigh = deviationHigh;
        }

        public BigDecimal getDeviationHighMinus() {
            return deviationHighMinus;
        }

        public void setDeviationHighMinus(BigDecimal deviationHighMinus) {
            this.deviationHighMinus = deviationHighMinus;
        }

        public BigDecimal getDeviationLow() {
            return deviationLow;
        }

        public void setDeviationLow(BigDecimal deviationLow) {
            this.deviationLow = deviationLow;
        }

        public BigDecimal getDeviationLowMinus() {
            return deviationLowMinus;
        }

        public void setDeviationLowMinus(BigDecimal deviationLowMinus) {
            this.deviationLowMinus = deviationLowMinus;
        }

        public BigDecimal getDeviationValue() {
            return deviationValue;
        }

        public void setDeviationValue(BigDecimal deviationValue) {
            this.deviationValue = deviationValue;
        }

        public BigDecimal getDeviationValueMinus() {
            return deviationValueMinus;
        }

        public void setDeviationValueMinus(BigDecimal deviationValueMinus) {
            this.deviationValueMinus = deviationValueMinus;
        }

        public List<BiddingScoreRequirement> getBiddingScoreRequirements() {
            return biddingScoreRequirements;
        }

        public void setBiddingScoreRequirements(List<BiddingScoreRequirement> biddingScoreRequirements) {
            this.biddingScoreRequirements = biddingScoreRequirements;
        }
    }

}
