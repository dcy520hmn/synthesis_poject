package com.springboot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TdPlanLeg {
    /**
     * 
     * 表字段 : td_plan_leg.PLEG_ID
     * 
     */
    private Long plegId;

    /**
     * 航班ID，关联航节，区分进出港
     * 表字段 : td_plan_leg.PFLT_ID
     * 
     */
    private Long pfltId;

    /**
     * 环ID，关联所有航节，含进出港
     * 表字段 : td_plan_leg.PFLT_LINK_ID
     * 
     */
    private Long pfltLinkId;

    /**
     * 同一航班的对应的航节序号
     * 表字段 : td_plan_leg.PLEG_INDEX
     * 
     */
    private Byte plegIndex;

    /**
     * 所属航空公司两字码
     * 表字段 : td_plan_leg.PLEG_AL_TW
     * 
     */
    private String plegAlTw;

    /**
     * 所属航空公司三字码
     * 表字段 : td_plan_leg.PLEG_AL_THR
     * 
     */
    private String plegAlThr;

    /**
     * 航空公司所属国家两字码
     * 表字段 : td_plan_leg.PLEG_AL_NACD_TW
     * 
     */
    private String plegAlNacdTw;

    /**
     * 航班号
     * 表字段 : td_plan_leg.PLEG_FLTNO
     * 
     */
    private String plegFltno;

    /**
     * 航班执行日期
     * 表字段 : td_plan_leg.PLEG_DATE
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate plegDate;

    /**
     *进出港类型：0，进港；1，出港
     * 原表中：PLEG_TYPE_A_D
     */
    private Byte plegTypeAD;
    /**
     * 国内/国际属性：0,国际；1，国内
     * 表字段 : td_plan_leg.PLEG_TYPE_I_D
     * 
     */
    private Byte plegTypeID;

    /**
     * 到达机位
     * 表字段 : td_plan_leg.PLEG_PARK_ARR
     * 
     */
    private String plegParkArr;

    /**
     * 起飞机位
     * 表字段 : td_plan_leg.PLEG_PARK_DEP
     * 
     */
    private String plegParkDep;

    /**
     * 航后机位
     * 表字段 : td_plan_leg.PLEG_PARK_WAIT
     * 
     */
    private String plegParkWait;

    /**
     * 机位国际/国内属性 (0/1)
     * 表字段 : td_plan_leg.PLEG_PARK_TYPE_I_D
     * 
     */
    private Byte plegParkTypeID;

    /**
     * 1:国内航班，2：国际航班有国内段
     * 表字段 : td_plan_leg.PLEG_SEG_I_D
     * 
     */
    private Byte plegSegID;

    /**
     * 是否代理(0/1)
     * 表字段 : td_plan_leg.PLEG_AGENT
     * 
     */
    private Byte plegAgent;

    /**
     * 出发代理
     * 表字段 : td_plan_leg.PLEG_DEPT_AGT
     * 
     */
    private String plegDeptAgt;

    /**
     * 到达代理
     * 表字段 : td_plan_leg.PLEG_ARR_AGT
     * 
     */
    private String plegArrAgt;

    /**
     * 是否是过站航班标识：０非过站，１过站
     * 表字段 : td_plan_leg.PLEG_TYPE_TRANSIT_FLAG
     * 
     */
    private Byte plegTypeTransitFlag;

    /**
     * 要客标志：1专机:Z、2VVIP:W、3要客包机:Y、4VIP:V、5会议代表:M、6CIP:C.以此级别由高到低排序，该字段只存放最高级别标志
            
     * 表字段 : td_plan_leg.PLEG_VIP_FLAG
     * 
     */
    private String plegVipFlag;

    /**
     * 航班标注
     * 表字段 : td_plan_leg.PLEG_REMARK
     * 
     */
    private String plegRemark;

    /**
     * 特服标志
     * 表字段 : td_plan_leg.PLEG_SP_FLAG
     * 
     */
    private String plegSpFlag;

    /**
     * 特服信息
     * 表字段 : td_plan_leg.PLEG_SP_INFO
     * 
     */
    private String plegSpInfo;

    /**
     * 特服旅客信息
     * 表字段 : td_plan_leg.PLEG_PSR_SPECIAL_ITEMS
     * 
     */
    private String plegPsrSpecialItems;

    /**
     * 航班状态,保存所有的航班状态，每次修改航班状态只是追加，只有取消航班状态才是删除
     * 表字段 : td_plan_leg.PLEG_STATUS
     * 
     */
    private String plegStatus;

    /**
     * 存放航班当前状态，前端显示“状态”来自该字段。add by lsx
     * 表字段 : td_plan_leg.PLEG_STATUS_CURRENT
     * 
     */
    private String plegStatusCurrent;

    /**
     * 出港备注
     * 表字段 : td_plan_leg.PLEG_COMMENT_DEP
     * 
     */
    private String plegCommentDep;

    /**
     * 进港备注
     * 表字段 : td_plan_leg.PLEG_COMMENT_ARR
     * 
     */
    private String plegCommentArr;

    /**
     * 航班关闭状态(CI/CCL/CC):初始关闭、中间关闭、最终关闭
     * 表字段 : td_plan_leg.PLEG_CLOSE_STATUS
     * 
     */
    private String plegCloseStatus;

    /**
     * 延误标志：0-不延误，1-延误
     * 表字段 : td_plan_leg.PLEG_DELAY_FLAG
     * 
     */
    private Byte plegDelayFlag;

    /**
     * 航班延误时间，单位为分钟
     * 表字段 : td_plan_leg.PLEG_DELAY_TM
     * 
     */
    private Integer plegDelayTm;

    /**
     * 延误原因
     * 表字段 : td_plan_leg.PLEG_DELAY_REASON
     * 
     */
    private String plegDelayReason;

    /**
     * 上客等待原因
     * 表字段 : td_plan_leg.PLEG_BRD_WAIT_REASON
     * 
     */
    private String plegBrdWaitReason;

    /**
     * 航班取消类型
     * 表字段 : td_plan_leg.PLEG_CANCEL_TYPE
     * 
     */
    private String plegCancelType;

    /**
     * 标志航班保障结束否，及结束标志（0：未结束，1：正常结束， -1:  非正常结束）
     * 表字段 : td_plan_leg.PLEG_FLT_END_FLAG
     * 
     */
    private Byte plegFltEndFlag;

    /**
     * 起飞机场中文名
     * 表字段 : td_plan_leg.PLEG_APNAME_CHN_DEP
     * 
     */
    private String plegApnameChnDep;

    /**
     * 起飞航站三字码
     * 表字段 : td_plan_leg.PLEG_AP_THR_DEP
     * 
     */
    private String plegApThrDep;

    /**
     * 起飞机场所在城市中文全称
     * 表字段 : td_plan_leg.PLEG_CYNAME_CHN_DEP
     * 
     */
    private String plegCynameChnDep;

    /**
     * 起飞机场所在城市中文简称
     * 表字段 : td_plan_leg.PLEG_CYABBRNAME_CHN_DEP
     * 
     */
    private String plegCyabbrnameChnDep;

    /**
     * 起飞城市英文名称
     * 表字段 : td_plan_leg.PLEG_CYNAME_ENG_DEP
     * 
     */
    private String plegCynameEngDep;

    /**
     * 起飞机场所属国家中文名
     * 表字段 : td_plan_leg.PLEG_NA_NAME_CHN_DEP
     * 
     */
    private String plegNaNameChnDep;

    /**
     * 起飞机场所属国家两字代码
     * 表字段 : td_plan_leg.PLEG_NACD_TW_DEP
     * 
     */
    private String plegNacdTwDep;

    /**
     * 到达航站三字码
     * 表字段 : td_plan_leg.PLEG_AP_THR_ARR
     * 
     */
    private String plegApThrArr;

    /**
     * 到达机场中文名
     * 表字段 : td_plan_leg.PLEG_APNAME_CHN_ARR
     * 
     */
    private String plegApnameChnArr;

    /**
     * 到达机场所在城市中文全称
     * 表字段 : td_plan_leg.PLEG_CYNAME_CHN_ARR
     * 
     */
    private String plegCynameChnArr;

    /**
     * 到达机场所在城市中文简称
     * 表字段 : td_plan_leg.PLEG_CYABBRNAME_CHN_ARR
     * 
     */
    private String plegCyabbrnameChnArr;

    /**
     * 到达城市英文名称
     * 表字段 : td_plan_leg.PLEG_CYNAME_ENG_ARR
     * 
     */
    private String plegCynameEngArr;

    /**
     * 到达机场所属国家中文名
     * 表字段 : td_plan_leg.PLEG_NA_NAME_CHN_ARR
     * 
     */
    private String plegNaNameChnArr;

    /**
     * 到达机场所属国家两字代码
     * 表字段 : td_plan_leg.PLEG_NACD_TW_ARR
     * 
     */
    private String plegNacdTwArr;

    /**
     * 国内值机柜台号
     * 表字段 : td_plan_leg.PLEG_CKI_COUNTER_NO
     * 
     */
    private String plegCkiCounterNo;

    /**
     * 国际值机柜台号
     * 表字段 : td_plan_leg.PLEG_CKI_COUNTER_NO_I
     * 
     */
    private String plegCkiCounterNoI;

    /**
     * 国内候机区
     * 表字段 : td_plan_leg.PLEG_WAIT_BRD_REGION_D
     * 
     */
    private String plegWaitBrdRegionD;

    /**
     * 国际候机区
     * 表字段 : td_plan_leg.PLEG_WAIT_BRD_REGION_I
     * 
     */
    private String plegWaitBrdRegionI;

    /**
     * 国内登机口
     * 表字段 : td_plan_leg.PLEG_BRD_GATE_D
     * 
     */
    private String plegBrdGateD;

    /**
     * 国内头等舱登机口
            (对于所有的国内远机位的飞机上的头等舱和公务舱的旅客需要有单独的登机口)
     * 表字段 : td_plan_leg.PLEG_BRD_GATE_F
     * 
     */
    private String plegBrdGateF;

    /**
     * 国际登机口
     * 表字段 : td_plan_leg.PLEG_BRD_GATE_I
     * 
     */
    private String plegBrdGateI;

    /**
     * 操作时间
     * 表字段 : td_plan_leg.PLEG_OP_TM
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegOpTm;

    /**
     * 允许登机时间
     * 表字段 : td_plan_leg.PLEG_TM_ALLOW_BRD
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmAllowBrd;

    /**
     * 靠桥时间
     * 表字段 : td_plan_leg.PLEG_TM_PULLON
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmPullon;

    /**
     * 撤桥时间
     * 表字段 : td_plan_leg.PLEG_TM_PULLOFF
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmPulloff;

    /**
     * 关舱门时间
     * 表字段 : td_plan_leg.PLEG_TM_CLOSE_DOOR
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmCloseDoor;

    /**
     * 开舱门时间
     * 表字段 : td_plan_leg.PLEG_TM_OPEN_DOOR
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmOpenDoor;

    /**
     * 飞机推出时间
     * 表字段 : td_plan_leg.PLEG_TM_PULLOUT
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmPullout;

    /**
     * 国内开柜台时间
     * 表字段 : td_plan_leg.PLEG_COP_TM_D
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegCopTmD;

    /**
     * 国际开柜台时间
     * 表字段 : td_plan_leg.PLEG_COP_TM_I
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegCopTmI;

    /**
     * 国内开柜台时间
     * 表字段 : td_plan_leg.PLEG_TM_CKI_BEGIN_D
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmCkiBeginD;

    /**
     * 国际开柜台时间
     * 表字段 : td_plan_leg.PLEG_TM_CKI_BEGIN_I
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmCkiBeginI;

    /**
     * 国内CCL 时间
     * 表字段 : td_plan_leg.PLEG_TM_CCL_D
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmCclD;

    /**
     * 国际CCL 时间
     * 表字段 : td_plan_leg.PLEG_TM_CCL_I
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmCclI;

    /**
     * 航班og关闭
     * 表字段 : td_plan_leg.PLEG_TM_OG_CLOSE
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmOgClose;

    /**
     * 初始关闭
     * 表字段 : td_plan_leg.PLEG_TM_CI
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmCi;

    /**
     * 最终关闭
     * 表字段 : td_plan_leg.PLEG_TM_CCL
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmCcl;

    /**
     * 国内上客时间
     * 表字段 : td_plan_leg.PLEG_TM_BRD_D
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmBrdD;

    /**
     * 国际上客时间
     * 表字段 : td_plan_leg.PLEG_TM_BRD_I
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmBrdI;

    /**
     * 国内上客取消
     * 表字段 : td_plan_leg.PLEG_TM_BRD_CNL_D
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmBrdCnlD;

    /**
     * 国际上客取消
     * 表字段 : td_plan_leg.PLEG_TM_BRD_CNL_I
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmBrdCnlI;

    /**
     * 国内客齐时间
     * 表字段 : td_plan_leg.PLEG_TM_PSA_D
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmPsaD;

    /**
     * 国际客齐时间
     * 表字段 : td_plan_leg.PLEG_TM_PSA_I
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmPsaI;

    /**
     * 客齐后（时间）？？
     * 表字段 : td_plan_leg.PLEG_TM_PSA_AFER
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmPsaAfer;

    /**
     * 国内关柜台时间
     * 表字段 : td_plan_leg.PLEG_TM_CI_D
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmCiD;

    /**
     * 国际关柜台时间
     * 表字段 : td_plan_leg.PLEG_TM_CI_I
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmCiI;

    /**
     * 进走廊时间
     * 表字段 : td_plan_leg.PLEG_TM_IN_CHANNEL
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmInChannel;

    /**
     * 入位时间
     * 表字段 : td_plan_leg.PLEG_TM_PULL_INTO
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmPullInto;

    /**
     * 预起
     * 表字段 : td_plan_leg.PLEG_TM_PTD
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmPtd;

    /**
     * 预起变更
     * 表字段 : td_plan_leg.PLEG_TM_ETD
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmEtd;

    /**
     * 离地
     * 表字段 : td_plan_leg.PLEG_TM_ATD
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmAtd;

    /**
     * 预达
     * 表字段 : td_plan_leg.PLEG_TM_PTA
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmPta;

    /**
     * 预达变更
     * 表字段 : td_plan_leg.PLEG_TM_ETA
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmEta;

    /**
     * 落地
     * 表字段 : td_plan_leg.PLEG_TM_ATA
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmAta;

    /**
     * 进港行李传送口
     * 表字段 : td_plan_leg.PLEG_BAG_TRANS_GATE_ARR
     * 
     */
    private String plegBagTransGateArr;

    /**
     * 出港行李分捡口
     * 表字段 : td_plan_leg.PLEG_BAG_TRANS_GATE_DEP
     * 
     */
    private String plegBagTransGateDep;

    /**
     * 进港行李提取转盘
     * 表字段 : td_plan_leg.PLEG_BAG_TRANS_BELT_ARR
     * 
     */
    private String plegBagTransBeltArr;

    /**
     * 中转行李导入口
     * 表字段 : td_plan_leg.PLEG_TRANSFER_BAG_IN_GATE
     * 
     */
    private String plegTransferBagInGate;

    /**
     * 上接飞航站三字码
     * 表字段 : td_plan_leg.PLEG_UPCP_AP_THR
     * 
     */
    private String plegUpcpApThr;

    /**
     * 上接飞航班
     * 表字段 : td_plan_leg.PLEG_UPCP_FLT
     * 
     */
    private String plegUpcpFlt;

    /**
     * 上接飞的预达时间
     * 表字段 : td_plan_leg.PLEG_TM_PRE_PTA
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmPrePta;

    /**
     * 上接飞的预达变更时间
     * 表字段 : td_plan_leg.PLEG_TM_PRE_ETA
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmPreEta;

    /**
     * 上接飞的落地时间
     * 表字段 : td_plan_leg.PLEG_TM_PRE_ATA
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmPreAta;

    /**
     * 下接飞航站三字码
     * 表字段 : td_plan_leg.PLEG_CP_AP_THR
     * 
     */
    private String plegCpApThr;

    /**
     * 下接飞航班
     * 表字段 : td_plan_leg.PLEG_CPFLT
     * 
     */
    private String plegCpflt;

    /**
     * 下接飞的预起时间
     * 表字段 : td_plan_leg.PLEG_TM_NEXT_PTD
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmNextPtd;

    /**
     * 下接飞的预起变更时间
     * 表字段 : td_plan_leg.PLEG_TM_NEXT_ETD
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmNextEtd;

    /**
     * 下接飞的离地时间
     * 表字段 : td_plan_leg.PLEG_TM_NEXT_ATD
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmNextAtd;

    /**
     * 航班数据变化标志
     * 表字段 : td_plan_leg.PLEG_SHOW_FLAG
     * 
     */
    private String plegShowFlag;

    /**
     * 计划发布标识:昨日:2 今日:6
     * 表字段 : td_plan_leg.PLEG_PUB_FLAG
     * 
     */
    private Byte plegPubFlag;

    /**
     * 0:近机位, 1:远机位 
     * 表字段 : td_plan_leg.PLEG_PARK_TYPE
     * 
     */
    private Byte plegParkType;

    /**
     * 国内进港旅客人数(F.C.Y)
     * 表字段 : td_plan_leg.PLEG_PNUM_ARR
     * 
     */
    private String plegPnumArr;

    /**
     * 国内进港旅客人数(成人，儿童，婴儿)
     * 表字段 : td_plan_leg.PLEG_PNUM_ACB_ARR
     * 
     */
    private String plegPnumAcbArr;

    /**
     * 国内客齐总人数（F.C.Y）
     * 表字段 : td_plan_leg.PLEG_PSA_NUM_D
     * 
     */
    private String plegPsaNumD;

    /**
     * 国内关闭总人数（F.C.Y）
     * 表字段 : td_plan_leg.PLEG_PSC_NUM_D
     * 
     */
    private String plegPscNumD;

    /**
     * 国内客齐总人数（成人.儿童.婴儿）
     * 表字段 : td_plan_leg.PLEG_PSA_NUM_ACB_D
     * 
     */
    private String plegPsaNumAcbD;

    /**
     * 国内关闭总人数（成人.儿童.婴儿）
     * 表字段 : td_plan_leg.PLEG_PSC_NUM_ACB_D
     * 
     */
    private String plegPscNumAcbD;

    /**
     * 国内进港行李(件数/重量)原字段PLEG_BAG_NUM_ARR
     * 表字段 : td_plan_leg.PLEG_BAG_NUM_ARR_D
     * 
     */
    private String plegBagNumArrD;

    /**
     * 国内客齐行李（件数/数量）
     * 表字段 : td_plan_leg.PLEG_PSA_BAG_D
     * 
     */
    private String plegPsaBagD;

    /**
     * 国内关闭行李（件数/重量)
     * 表字段 : td_plan_leg.PLEG_PSC_BAG_D
     * 
     */
    private String plegPscBagD;

    /**
     * 进港中转旅客人数(F.C.Y)
     * 表字段 : td_plan_leg.PLEG_PNUM_TRANSFER_ARR
     * 
     */
    private String plegPnumTransferArr;

    /**
     * 进港中转旅客行李(件数/重量)
     * 表字段 : td_plan_leg.PLEG_BAG_NUM_TRANSFER_ARR
     * 
     */
    private String plegBagNumTransferArr;

    /**
     * 中转旅客人数
     * 表字段 : td_plan_leg.PLEG_TRANSFER_PNUM
     * 
     */
    private String plegTransferPnum;

    /**
     * 中转行李数量
     * 表字段 : td_plan_leg.PLEG_TRANSFER_BAG_NUM
     * 
     */
    private String plegTransferBagNum;

    /**
     * 中转行李重量
     * 表字段 : td_plan_leg.PLEG_TRANSFER_BAG_WEIGHT
     * 
     */
    private String plegTransferBagWeight;

    /**
     * 国际进港旅客人数(F.C.Y)
     * 表字段 : td_plan_leg.PLEG_PNUM_ARR_I
     * 
     */
    private String plegPnumArrI;

    /**
     * 国际进港旅客人数(成人，儿童，婴儿)
     * 表字段 : td_plan_leg.PLEG_PNUM_ACB_ARR_I
     * 
     */
    private String plegPnumAcbArrI;

    /**
     * 国际客齐总人数（F.C.Y）
     * 表字段 : td_plan_leg.PLEG_PSA_NUM_I
     * 
     */
    private String plegPsaNumI;

    /**
     * 国际关闭总人数（F.C.Y）
     * 表字段 : td_plan_leg.PLEG_PSC_NUM_I
     * 
     */
    private String plegPscNumI;

    /**
     * 国际客齐总人数（成人.儿童.婴儿）
     * 表字段 : td_plan_leg.PLEG_PSA_NUM_ACB_I
     * 
     */
    private String plegPsaNumAcbI;

    /**
     * 国际关闭总人数（成人.儿童.婴儿）
     * 表字段 : td_plan_leg.PLEG_PSC_NUM_ACB_I
     * 
     */
    private String plegPscNumAcbI;

    /**
     * 国际进港行李(件数/重量)
     * 表字段 : td_plan_leg.PLEG_BAG_NUM_ARR_I
     * 
     */
    private String plegBagNumArrI;

    /**
     * 国际客齐行李（件数/数量）
     * 表字段 : td_plan_leg.PLEG_PSA_BAG_I
     * 
     */
    private String plegPsaBagI;

    /**
     * 国际关闭行李(数量/重量)
     * 表字段 : td_plan_leg.PLEG_PSC_BAG_I
     * 
     */
    private String plegPscBagI;

    /**
     * 国际实际装机行李件数
     * 表字段 : td_plan_leg.PLEG_LOAD_BAG_NUM_I
     * 
     */
    private String plegLoadBagNumI;

    /**
     * 过站人数（F.C.Y）
     * 表字段 : td_plan_leg.PLEG_GZ_NUM
     * 
     */
    private String plegGzNum;

    /**
     * 过站人数（成人.儿童.婴儿 ）
     * 表字段 : td_plan_leg.PLEG_GZ_NUM_ACB
     * 
     */
    private String plegGzNumAcb;

    /**
     * 过站行李（件数/数量）
     * 表字段 : td_plan_leg.PLEG_GZ_BAG
     * 
     */
    private String plegGzBag;

    /**
     * 订座总人数（F.C.Y）
     * 表字段 : td_plan_leg.PLEG_RES_PNUM
     * 
     */
    private String plegResPnum;

    /**
     * 订座总人数（成人，儿童，婴儿）
     * 表字段 : td_plan_leg.PLEG_RES_PNUM_ACB
     * 
     */
    private String plegResPnumAcb;

    /**
     * 订座国内行李（件数/重量)
     * 表字段 : td_plan_leg.PLEG_RES_BAG_D
     * 
     */
    private String plegResBagD;

    /**
     * 订座国际总人数（F.C.Y）
     * 表字段 : td_plan_leg.PLEG_RES_PNUM_I
     * 
     */
    private String plegResPnumI;

    /**
     * 订座国际总人数（成人，儿童，婴儿）
     * 表字段 : td_plan_leg.PLEG_RES_PNUM_ACB_I
     * 
     */
    private String plegResPnumAcbI;

    /**
     * 订座国际行李(件数/重量)
     * 表字段 : td_plan_leg.PLEG_RES_BAG_I
     * 
     */
    private String plegResBagI;

    /**
     * 国内OG总人数（F.C.J.Y）
     * 表字段 : td_plan_leg.PLEG_OG_NUM_D
     * 
     */
    private String plegOgNumD;

    /**
     * 国内OG行李（件数/数量）
     * 表字段 : td_plan_leg.PLEG_OG_BAG_D
     * 
     */
    private String plegOgBagD;

    /**
     * 国际OG总人数（F.C.J.Y）
     * 表字段 : td_plan_leg.PLEG_OG_NUM_I
     * 
     */
    private String plegOgNumI;

    /**
     * 国际OG行李（件数/数量）
     * 表字段 : td_plan_leg.PLEG_OG_BAG_I
     * 
     */
    private String plegOgBagI;

    /**
     * 国内OG总人数（成人.儿童.婴儿）
     * 表字段 : td_plan_leg.PLEG_OG_NUM_ACB_D
     * 
     */
    private String plegOgNumAcbD;

    /**
     * 国际OG总人数（成人.儿童.婴儿）
     * 表字段 : td_plan_leg.PLEG_OG_NUM_ACB_I
     * 
     */
    private String plegOgNumAcbI;

    /**
     * 来自 ldm的人数（ F.C.Y）
     * 表字段 : td_plan_leg.PLEG_LDM_PSR_FCY
     * 
     */
    private String plegLdmPsrFcy;

    /**
     * 来自 ldm的行李(件数/重量)
     * 表字段 : td_plan_leg.PLEG_LDM_BAG
     * 
     */
    private String plegLdmBag;

    /**
     * 来自 ldm中转的人数（ F.C.Y）
     * 表字段 : td_plan_leg.PLEG_LDM_PSR_TRSF_FCY
     * 
     */
    private String plegLdmPsrTrsfFcy;

    /**
     * 来自 ldm的中转人数（ 成人.儿童.婴儿）
     * 表字段 : td_plan_leg.PLEG_LDM_PSR_TRSF_ACB
     * 
     */
    private String plegLdmPsrTrsfAcb;

    /**
     * 来自 ldm的人数（ 成人.儿童.婴儿）
     * 表字段 : td_plan_leg.PLEG_LDM_PSR_ACB
     * 
     */
    private String plegLdmPsrAcb;

    /**
     * 来自 ldm的中转行李(件数/重量)
     * 表字段 : td_plan_leg.PLEG_LDM_BAG_TRSF
     * 
     */
    private String plegLdmBagTrsf;

    /**
     * 该航班是否收到报文0：未收到1：收全2：未收全 报文收全的标准是：所有和本地航站相关的航段都收到LDM信息了
     * 表字段 : td_plan_leg.PLEG_LDM_FLAG
     * 
     */
    private Byte plegLdmFlag;

    /**
     * 航班信息处理标志
            0：未处理完
            1：封存
            2：放弃航班（可能是因为航班建立的时候就不对）
            3：航班信息已经经过修改和确认，用于在导入FCS数据出现异常时进行手工调整
     * 表字段 : td_plan_leg.PLEG_LDM_STATUS
     * 
     */
    private Byte plegLdmStatus;

    /**
     * 订座人数，成人，如F1C2Y3
     * 表字段 : td_plan_leg.PLEG_RES_ADULT_FCY
     * 
     */
    private String plegResAdultFcy;

    /**
     * 订座人数，儿童，如F1C2Y3
     * 表字段 : td_plan_leg.PLEG_RES_CHILD_FCY
     * 
     */
    private String plegResChildFcy;

    /**
     * 订座人数，婴儿，如F1C2Y3
     * 表字段 : td_plan_leg.PLEG_RES_INFANT_FCY
     * 
     */
    private String plegResInfantFcy;

    /**
     * 值机人数，成人，如F1C2Y3
     * 表字段 : td_plan_leg.PLEG_CKI_ADULT_FCY
     * 
     */
    private String plegCkiAdultFcy;

    /**
     * 值机人数，儿童，如F1C2Y3
     * 表字段 : td_plan_leg.PLEG_CKI_CHILD_FCY
     * 
     */
    private String plegCkiChildFcy;

    /**
     * 值机人数，婴儿，如F1C2Y3
     * 表字段 : td_plan_leg.PLEG_CKI_INFANT_FCY
     * 
     */
    private String plegCkiInfantFcy;

    /**
     * 登机人数，成人，如F1C2Y3
     * 表字段 : td_plan_leg.PLEG_BRD_ADULT_FCY
     * 
     */
    private String plegBrdAdultFcy;

    /**
     * 登机人数，儿童，如F1C2Y3
     * 表字段 : td_plan_leg.PLEG_BRD_CHILD_FCY
     * 
     */
    private String plegBrdChildFcy;

    /**
     * 登机人数，婴儿，如F1C2Y3
     * 表字段 : td_plan_leg.PLEG_BRD_INFANT_FCY
     * 
     */
    private String plegBrdInfantFcy;

    /**
     * 行李件数
     * 表字段 : td_plan_leg.PLEG_BGG_UNIT
     * 
     */
    private String plegBggUnit;

    /**
     * 行李重量
     * 表字段 : td_plan_leg.PLEG_BGG_WEIGHT
     * 
     */
    private String plegBggWeight;

    /**
     * 货物重量
     * 表字段 : td_plan_leg.PLEG_CGO_WEIGHT
     * 
     */
    private String plegCgoWeight;

    /**
     * 邮件重量
     * 表字段 : td_plan_leg.PLEG_MAIL_WEIGHT
     * 
     */
    private String plegMailWeight;

    /**
     * 总重量
     * 表字段 : td_plan_leg.PLEG_TOTAL_WEIGHT
     * 
     */
    private String plegTotalWeight;

    /**
     * 航班讲评
     * 表字段 : td_plan_leg.PLEG_DELAY_REVIEW
     * 
     */
    private String plegDelayReview;

    /**
     * 航线id
     * 表字段 : td_plan_leg.SWIS_ID
     * 
     */
    private String swisId;

    /**
     * 用来存放完整的到达航班三字代码 如WUH/HAK
     * 表字段 : td_plan_leg.PLEG_AP_THR_ARR_ALL
     * 
     */
    private String plegApThrArrAll;

    /**
     * 用来存放完整的起始航班三字代码 如WUH/HAK
     * 表字段 : td_plan_leg.PLEG_AP_THR_DEP_ALL
     * 
     */
    private String plegApThrDepAll;

    /**
     * 传给dcs主机的国内登机口
     * 表字段 : td_plan_leg.PLEG_BRD_GATE_D_DCS
     * 
     */
    private String plegBrdGateDDcs;

    /**
     * 传给dcs主机的国际登机口
     * 表字段 : td_plan_leg.PLEG_BRD_GATE_I_DCS
     * 
     */
    private String plegBrdGateIDcs;

    /**
     * 值机状态
     * 表字段 : td_plan_leg.PLEG_CKI_STATUS
     * 
     */
    private String plegCkiStatus;

    /**
     * 中转衔接状态
     * 表字段 : td_plan_leg.PLEG_TRANSFER_STATUS
     * 
     */
    private String plegTransferStatus;

    /**
     * go-show限额
     * 表字段 : td_plan_leg.PLEG_GS_LIMITED
     * 
     */
    private String plegGsLimited;

    /**
     * 候机厅
     * 表字段 : td_plan_leg.PLEG_WAIT_ROOM
     * 
     */
    private String plegWaitRoom;

    /**
     * 到达门
     * 表字段 : td_plan_leg.PLEG_ARR_GATE
     * 
     */
    private String plegArrGate;

    /**
     * 到达厅
     * 表字段 : td_plan_leg.PLEG_ARR_ROOM
     * 
     */
    private String plegArrRoom;

    /**
     * 订座总人数
     * 表字段 : td_plan_leg.PLEG_PNUM_RES_ALL
     * 
     */
    private String plegPnumResAll;

    /**
     * 值机总人数
     * 表字段 : td_plan_leg.PLEG_PNUM_CKI_ALL
     * 
     */
    private String plegPnumCkiAll;

    /**
     * 登机总人数
     * 表字段 : td_plan_leg.PLEG_PNUM_BRD_ALL
     * 
     */
    private String plegPnumBrdAll;

    /**
     * VIP服务时间
     * 表字段 : td_plan_leg.PLEG_VIPSVC_TIME
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegVipsvcTime;

    /**
     * 特服服务时间
     * 表字段 : td_plan_leg.PLEG_SPCSVC_TIME
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegSpcsvcTime;

    /**
     * 飞行时间
     * 表字段 : td_plan_leg.PLEG_FPL_FLIGHT_TIME
     * 
     */
    private String plegFplFlightTime;

    /**
     * 机组人数 原字段PLEG_CAPT_NAME
     * 表字段 : td_plan_leg.PLEG_CAPT_NUM
     * 
     */
    private String plegCaptNum;

    /**
     * 廊桥（桥口）
     * 表字段 : td_plan_leg.PLEG_AIR_BRIDGE
     * 
     */
    private String plegAirBridge;

    /**
     * 转机行李件数
     * 表字段 : td_plan_leg.PLEG_BAG_EXCHANGE_NUM
     * 
     */
    private String plegBagExchangeNum;

    /**
     * 转机行李重量
     * 表字段 : td_plan_leg.PLEG_BAG_EXCHANGE_WEIGHT
     * 
     */
    private String plegBagExchangeWeight;

    /**
     * 通程旅客人数
     * 表字段 : td_plan_leg.PLEG_PAX_THROUGH_NUM
     * 
     */
    private String plegPaxThroughNum;

    /**
     * 通程行李件数
     * 表字段 : td_plan_leg.PLEG_BAG_THROUGH_NUM
     * 
     */
    private String plegBagThroughNum;

    /**
     * 通程行李重量
     * 表字段 : td_plan_leg.PLEG_BAG_THROUGH_WEIGHT
     * 
     */
    private String plegBagThroughWeight;

    /**
     * 无人陪儿童被叫人数
     * 表字段 : td_plan_leg.PLEG_CHILD_ALONE_NUM
     * 
     */
    private String plegChildAloneNum;

    /**
     * 无人陪老人被叫人数
     * 表字段 : td_plan_leg.PLEG_ELDER_ALONE_NUM
     * 
     */
    private String plegElderAloneNum;

    /**
     * 普通轮椅被叫个数
     * 表字段 : td_plan_leg.PLEG_PAX_WHCH_NUM
     * 
     */
    private String plegPaxWhchNum;

    /**
     * 盲人被叫人数
     * 表字段 : td_plan_leg.PLEG_PAX_BLND_NUM
     * 
     */
    private String plegPaxBlndNum;

    /**
     * 未运出行李数量
     * 表字段 : td_plan_leg.PLEG_BAG_NOTDONE_NUM
     * 
     */
    private String plegBagNotdoneNum;

    /**
     * 卡手提行李件数
     * 表字段 : td_plan_leg.PLEG_HANDBAG_NUM
     * 
     */
    private String plegHandbagNum;

    /**
     * 未运出行李重量
     * 表字段 : td_plan_leg.PLEG_BAG_NOTDONE_WEIGHT
     * 
     */
    private String plegBagNotdoneWeight;

    /**
     * 卡手提行李重量
     * 表字段 : td_plan_leg.PLEG_HANDBAG_WHT
     * 
     */
    private String plegHandbagWht;

    /**
     * 翻舱行李件数
     * 表字段 : td_plan_leg.PLEG_BAG_FANCANG_NUM
     * 
     */
    private String plegBagFancangNum;

    /**
     * 翻舱行李重量
     * 表字段 : td_plan_leg.PLEG_BAG_FANCANG_WEIGHT
     * 
     */
    private String plegBagFancangWeight;

    /**
     * 最终减行李件数
     * 表字段 : td_plan_leg.PLEG_BAG_CUT_NUM
     * 
     */
    private String plegBagCutNum;

    /**
     * 最终减行李重量
     * 表字段 : td_plan_leg.PLEG_BAG_CUT_WEIGHT
     * 
     */
    private String plegBagCutWeight;

    /**
     * 迟下行李件数
            
     * 表字段 : td_plan_leg.PLEG_BAG_DELAY_NUM
     * 
     */
    private String plegBagDelayNum;

    /**
     * 迟下行李重量
     * 表字段 : td_plan_leg.PLEG_BAG_DELAY_WEIGHT
     * 
     */
    private String plegBagDelayWeight;

    /**
     * 聋哑被叫人数
     * 表字段 : td_plan_leg.PLEG_PAX_DEAF_NUM
     * 
     */
    private String plegPaxDeafNum;

    /**
     * 机上轮椅被叫个数
     * 表字段 : td_plan_leg.PLEG_PAX_FLT_WHCH_NUM
     * 
     */
    private String plegPaxFltWhchNum;

    /**
     * 其他服务被叫数量
     * 表字段 : td_plan_leg.PLEG_OTHER_NUM
     * 
     */
    private String plegOtherNum;

    /**
     * 无人陪儿童实际人数
     * 表字段 : td_plan_leg.PLEG_CHILD_ALONE_TNUM
     * 
     */
    private String plegChildAloneTnum;

    /**
     * 无人陪老人实际数
     * 表字段 : td_plan_leg.PLEG_ELDER_ALONE_TNUM
     * 
     */
    private String plegElderAloneTnum;

    /**
     * 盲人实际人数
     * 表字段 : td_plan_leg.PLEG_PAX_BLND_TNUM
     * 
     */
    private String plegPaxBlndTnum;

    /**
     * 聋哑实际人数
     * 表字段 : td_plan_leg.PLEG_PAX_DEAF_TNUM
     * 
     */
    private String plegPaxDeafTnum;

    /**
     * 机上轮椅实际个数
     * 表字段 : td_plan_leg.PLEG_PAX_FLT_WHCH_TNUM
     * 
     */
    private String plegPaxFltWhchTnum;

    /**
     * 普通轮椅实际个数
     * 表字段 : td_plan_leg.PLEG_PAX_WHCH_TNUM
     * 
     */
    private String plegPaxWhchTnum;

    /**
     * 其他服务实际数量
     * 表字段 : td_plan_leg.PLEG_OTHER_TNUM
     * 
     */
    private String plegOtherTnum;

    /**
     * 担架实际人数
     * 表字段 : td_plan_leg.PLEG_PAX_STCR_NUM
     * 
     */
    private String plegPaxStcrNum;

    /**
     * 标记航班特殊状态，比如除冰除雪
     * 表字段 : td_plan_leg.PLEG_TAG
     * 
     */
    private String plegTag;

    /**
     * ready一段时间内是否有TSAT
     * 表字段 : td_plan_leg.PLEG_HAS_TSAT
     * 
     */
    private Byte plegHasTsat;

    /**
     * 飞机注册号
     * 表字段 : td_plan_leg.PLEG_REGNO
     * 
     */
    private String plegRegno;

    /**
     * 机型全称
     * 表字段 : td_plan_leg.PLEG_PLANE_TYPE
     * 
     */
    private String plegPlaneType;

    /**
     * 飞机类型三字码
     * 表字段 : td_plan_leg.PLEG_PLANE_TYPE_THR
     * 
     */
    private String plegPlaneTypeThr;

    /**
     * 是否是宽体航班, 1:   宽体, 0: 窄体
     * 表字段 : td_plan_leg.PLEG_ISKT
     * 
     */
    private Byte plegIskt;

    /**
     * 舱位布局
     * 表字段 : td_plan_leg.PLEG_SEAT_CONFIG
     * 
     */
    private String plegSeatConfig;

    /**
     * 是否是货机
     * 表字段 : td_plan_leg.PLEG_ISCARGO
     * 
     */
    private Byte plegIscargo;

    /**
     * 匹配航班号
     * 表字段 : td_plan_leg.PLEG_REL_FLT_NO
     * 
     */
    private String plegRelFltNo;

    /**
     * 曾经使用过的航班号，包括共享航班、虚拟航班等，航班号之间用“，”隔开
     * 表字段 : td_plan_leg.PLEG_FLTNO_CHG
     * 
     */
    private String plegFltnoChg;

    /**
     * 备降场
     * 表字段 : td_plan_leg.PLEG_BJC
     * 
     */
    private String plegBjc;

    /**
     * 备降场三字代码
     * 表字段 : td_plan_leg.PLEG_BJC_THR
     * 
     */
    private String plegBjcThr;

    /**
     * 航班模式
     * 表字段 : td_plan_leg.PLEG_FLT_MODE
     * 
     */
    private String plegFltMode;

    /**
     * 航班性质
     * 表字段 : td_plan_leg.PLEG_FLT_PROP
     * 
     */
    private String plegFltProp;

    /**
     * 航班任务类型 ,来自航行原始数据
     * 表字段 : td_plan_leg.PLEG_TASK_CODE
     * 
     */
    private String plegTaskCode;

    /**
     * 共享航班
     * 表字段 : td_plan_leg.PLEG_SHARE
     * 
     */
    private String plegShare;

    /**
     * 虚拟航班
     * 表字段 : td_plan_leg.PLEG_VIRTUAL_FLT
     * 
     */
    private String plegVirtualFlt;

    /**
     * 航段（原有字段）
     * 表字段 : td_plan_leg.PLEG_STATIONS
     * 
     */
    private String plegStations;

    /**
     * 整型备用字段01
     * 表字段 : td_plan_leg.PLEG_NUM_STANDBY_01
     * 
     */
    private Byte plegNumStandby01;

    /**
     * 整型备用字段02
     * 表字段 : td_plan_leg.PLEG_NUM_STANDBY_02
     * 
     */
    private Byte plegNumStandby02;

    /**
     * 字符型备用字段
     * 表字段 : td_plan_leg.PLEG_STR_STANDBY_01
     * 
     */
    private String plegStrStandby01;

    /**
     * 字符型备用字段
     * 表字段 : td_plan_leg.PLEG_STR_STANDBY_02
     * 
     */
    private String plegStrStandby02;

    /**
     * 关客舱门
     * 表字段 : td_plan_leg.PLEG_TM_STANDBY_01
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmStandby01;

    /**
     * 关货舱门
     * 表字段 : td_plan_leg.PLEG_TM_STANDBY_02
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmStandby02;

    /**
     * 建议推出时间
     * 表字段 : td_plan_leg.PLEG_TM_STANDBY_03
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmStandby03;

    /**
     * 建议离地时间
     * 表字段 : td_plan_leg.PLEG_TM_STANDBY_04
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmStandby04;

    /**
     * OMIS不正常航班计达时间(OMISEta)
     * 表字段 : td_plan_leg.PLEG_TM_STANDBY_05
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmStandby05;

    /**
     * 用于存储“TSAT时间”
     * 表字段 : td_plan_leg.PLEG_TM_STANDBY_06
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmStandby06;

    /**
     * 用于存储“CTOT时间”
     * 表字段 : td_plan_leg.PLEG_TM_STANDBY_07
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmStandby07;

    /**
     * 用于存储“飞机Ready时间”
     * 表字段 : td_plan_leg.PLEG_TM_STANDBY_08
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmStandby08;

    /**
     * 
     * 表字段 : td_plan_leg.PLEG_TM_STANDBY_09
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmStandby09;

    /**
     * 
     * 表字段 : td_plan_leg.PLEG_TM_STANDBY_10
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmStandby10;

    /**
     * 
     * 表字段 : td_plan_leg.PLEG_TM_STANDBY_11
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmStandby11;

    /**
     * 
     * 表字段 : td_plan_leg.PLEG_TM_STANDBY_12
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime plegTmStandby12;

    /**
     * 飞机环id
     * 表字段 : td_plan_leg.FTRG_ID
     * 
     */
    private Long ftrgId;

    public Long getPlegId() {
        return plegId;
    }

    public void setPlegId(Long plegId) {
        this.plegId = plegId;
    }

    public Long getPfltId() {
        return pfltId;
    }

    public void setPfltId(Long pfltId) {
        this.pfltId = pfltId;
    }

    public Long getPfltLinkId() {
        return pfltLinkId;
    }

    public void setPfltLinkId(Long pfltLinkId) {
        this.pfltLinkId = pfltLinkId;
    }

    public Byte getPlegIndex() {
        return plegIndex;
    }

    public void setPlegIndex(Byte plegIndex) {
        this.plegIndex = plegIndex;
    }

    public String getPlegAlTw() {
        return plegAlTw;
    }

    public void setPlegAlTw(String plegAlTw) {
        this.plegAlTw = plegAlTw == null ? null : plegAlTw.trim();
    }

    public String getPlegAlThr() {
        return plegAlThr;
    }

    public void setPlegAlThr(String plegAlThr) {
        this.plegAlThr = plegAlThr == null ? null : plegAlThr.trim();
    }

    public String getPlegAlNacdTw() {
        return plegAlNacdTw;
    }

    public void setPlegAlNacdTw(String plegAlNacdTw) {
        this.plegAlNacdTw = plegAlNacdTw == null ? null : plegAlNacdTw.trim();
    }

    public String getPlegFltno() {
        return plegFltno;
    }

    public void setPlegFltno(String plegFltno) {
        this.plegFltno = plegFltno == null ? null : plegFltno.trim();
    }

    public LocalDate getPlegDate() {
        return plegDate;
    }

    public void setPlegDate(LocalDate plegDate) {
        this.plegDate = plegDate;
    }

    public Byte getPlegTypeID() {
        return plegTypeID;
    }

    public void setPlegTypeID(Byte plegTypeID) {
        this.plegTypeID = plegTypeID;
    }

    public String getPlegParkArr() {
        return plegParkArr;
    }

    public void setPlegParkArr(String plegParkArr) {
        this.plegParkArr = plegParkArr == null ? null : plegParkArr.trim();
    }

    public String getPlegParkDep() {
        return plegParkDep;
    }

    public void setPlegParkDep(String plegParkDep) {
        this.plegParkDep = plegParkDep == null ? null : plegParkDep.trim();
    }

    public String getPlegParkWait() {
        return plegParkWait;
    }

    public void setPlegParkWait(String plegParkWait) {
        this.plegParkWait = plegParkWait == null ? null : plegParkWait.trim();
    }

    public Byte getPlegParkTypeID() {
        return plegParkTypeID;
    }

    public void setPlegParkTypeID(Byte plegParkTypeID) {
        this.plegParkTypeID = plegParkTypeID;
    }

    public Byte getPlegSegID() {
        return plegSegID;
    }

    public void setPlegSegID(Byte plegSegID) {
        this.plegSegID = plegSegID;
    }

    public Byte getPlegAgent() {
        return plegAgent;
    }

    public void setPlegAgent(Byte plegAgent) {
        this.plegAgent = plegAgent;
    }

    public String getPlegDeptAgt() {
        return plegDeptAgt;
    }

    public void setPlegDeptAgt(String plegDeptAgt) {
        this.plegDeptAgt = plegDeptAgt == null ? null : plegDeptAgt.trim();
    }

    public String getPlegArrAgt() {
        return plegArrAgt;
    }

    public void setPlegArrAgt(String plegArrAgt) {
        this.plegArrAgt = plegArrAgt == null ? null : plegArrAgt.trim();
    }

    public Byte getPlegTypeTransitFlag() {
        return plegTypeTransitFlag;
    }

    public void setPlegTypeTransitFlag(Byte plegTypeTransitFlag) {
        this.plegTypeTransitFlag = plegTypeTransitFlag;
    }

    public String getPlegVipFlag() {
        return plegVipFlag;
    }

    public void setPlegVipFlag(String plegVipFlag) {
        this.plegVipFlag = plegVipFlag == null ? null : plegVipFlag.trim();
    }

    public String getPlegRemark() {
        return plegRemark;
    }

    public void setPlegRemark(String plegRemark) {
        this.plegRemark = plegRemark == null ? null : plegRemark.trim();
    }

    public String getPlegSpFlag() {
        return plegSpFlag;
    }

    public void setPlegSpFlag(String plegSpFlag) {
        this.plegSpFlag = plegSpFlag == null ? null : plegSpFlag.trim();
    }

    public String getPlegSpInfo() {
        return plegSpInfo;
    }

    public void setPlegSpInfo(String plegSpInfo) {
        this.plegSpInfo = plegSpInfo == null ? null : plegSpInfo.trim();
    }

    public String getPlegPsrSpecialItems() {
        return plegPsrSpecialItems;
    }

    public void setPlegPsrSpecialItems(String plegPsrSpecialItems) {
        this.plegPsrSpecialItems = plegPsrSpecialItems == null ? null : plegPsrSpecialItems.trim();
    }

    public String getPlegStatus() {
        return plegStatus;
    }

    public void setPlegStatus(String plegStatus) {
        this.plegStatus = plegStatus == null ? null : plegStatus.trim();
    }

    public String getPlegStatusCurrent() {
        return plegStatusCurrent;
    }

    public void setPlegStatusCurrent(String plegStatusCurrent) {
        this.plegStatusCurrent = plegStatusCurrent == null ? null : plegStatusCurrent.trim();
    }

    public String getPlegCommentDep() {
        return plegCommentDep;
    }

    public void setPlegCommentDep(String plegCommentDep) {
        this.plegCommentDep = plegCommentDep == null ? null : plegCommentDep.trim();
    }

    public String getPlegCommentArr() {
        return plegCommentArr;
    }

    public void setPlegCommentArr(String plegCommentArr) {
        this.plegCommentArr = plegCommentArr == null ? null : plegCommentArr.trim();
    }

    public String getPlegCloseStatus() {
        return plegCloseStatus;
    }

    public void setPlegCloseStatus(String plegCloseStatus) {
        this.plegCloseStatus = plegCloseStatus == null ? null : plegCloseStatus.trim();
    }

    public Byte getPlegDelayFlag() {
        return plegDelayFlag;
    }

    public void setPlegDelayFlag(Byte plegDelayFlag) {
        this.plegDelayFlag = plegDelayFlag;
    }

    public Integer getPlegDelayTm() {
        return plegDelayTm;
    }

    public void setPlegDelayTm(Integer plegDelayTm) {
        this.plegDelayTm = plegDelayTm;
    }

    public String getPlegDelayReason() {
        return plegDelayReason;
    }

    public void setPlegDelayReason(String plegDelayReason) {
        this.plegDelayReason = plegDelayReason == null ? null : plegDelayReason.trim();
    }

    public String getPlegBrdWaitReason() {
        return plegBrdWaitReason;
    }

    public void setPlegBrdWaitReason(String plegBrdWaitReason) {
        this.plegBrdWaitReason = plegBrdWaitReason == null ? null : plegBrdWaitReason.trim();
    }

    public String getPlegCancelType() {
        return plegCancelType;
    }

    public void setPlegCancelType(String plegCancelType) {
        this.plegCancelType = plegCancelType == null ? null : plegCancelType.trim();
    }

    public Byte getPlegFltEndFlag() {
        return plegFltEndFlag;
    }

    public void setPlegFltEndFlag(Byte plegFltEndFlag) {
        this.plegFltEndFlag = plegFltEndFlag;
    }

    public String getPlegApnameChnDep() {
        return plegApnameChnDep;
    }

    public void setPlegApnameChnDep(String plegApnameChnDep) {
        this.plegApnameChnDep = plegApnameChnDep == null ? null : plegApnameChnDep.trim();
    }

    public String getPlegApThrDep() {
        return plegApThrDep;
    }

    public void setPlegApThrDep(String plegApThrDep) {
        this.plegApThrDep = plegApThrDep == null ? null : plegApThrDep.trim();
    }

    public String getPlegCynameChnDep() {
        return plegCynameChnDep;
    }

    public void setPlegCynameChnDep(String plegCynameChnDep) {
        this.plegCynameChnDep = plegCynameChnDep == null ? null : plegCynameChnDep.trim();
    }

    public String getPlegCyabbrnameChnDep() {
        return plegCyabbrnameChnDep;
    }

    public void setPlegCyabbrnameChnDep(String plegCyabbrnameChnDep) {
        this.plegCyabbrnameChnDep = plegCyabbrnameChnDep == null ? null : plegCyabbrnameChnDep.trim();
    }

    public String getPlegCynameEngDep() {
        return plegCynameEngDep;
    }

    public void setPlegCynameEngDep(String plegCynameEngDep) {
        this.plegCynameEngDep = plegCynameEngDep == null ? null : plegCynameEngDep.trim();
    }

    public String getPlegNaNameChnDep() {
        return plegNaNameChnDep;
    }

    public void setPlegNaNameChnDep(String plegNaNameChnDep) {
        this.plegNaNameChnDep = plegNaNameChnDep == null ? null : plegNaNameChnDep.trim();
    }

    public String getPlegNacdTwDep() {
        return plegNacdTwDep;
    }

    public void setPlegNacdTwDep(String plegNacdTwDep) {
        this.plegNacdTwDep = plegNacdTwDep == null ? null : plegNacdTwDep.trim();
    }

    public String getPlegApThrArr() {
        return plegApThrArr;
    }

    public void setPlegApThrArr(String plegApThrArr) {
        this.plegApThrArr = plegApThrArr == null ? null : plegApThrArr.trim();
    }

    public String getPlegApnameChnArr() {
        return plegApnameChnArr;
    }

    public void setPlegApnameChnArr(String plegApnameChnArr) {
        this.plegApnameChnArr = plegApnameChnArr == null ? null : plegApnameChnArr.trim();
    }

    public String getPlegCynameChnArr() {
        return plegCynameChnArr;
    }

    public void setPlegCynameChnArr(String plegCynameChnArr) {
        this.plegCynameChnArr = plegCynameChnArr == null ? null : plegCynameChnArr.trim();
    }

    public String getPlegCyabbrnameChnArr() {
        return plegCyabbrnameChnArr;
    }

    public void setPlegCyabbrnameChnArr(String plegCyabbrnameChnArr) {
        this.plegCyabbrnameChnArr = plegCyabbrnameChnArr == null ? null : plegCyabbrnameChnArr.trim();
    }

    public String getPlegCynameEngArr() {
        return plegCynameEngArr;
    }

    public void setPlegCynameEngArr(String plegCynameEngArr) {
        this.plegCynameEngArr = plegCynameEngArr == null ? null : plegCynameEngArr.trim();
    }

    public String getPlegNaNameChnArr() {
        return plegNaNameChnArr;
    }

    public void setPlegNaNameChnArr(String plegNaNameChnArr) {
        this.plegNaNameChnArr = plegNaNameChnArr == null ? null : plegNaNameChnArr.trim();
    }

    public String getPlegNacdTwArr() {
        return plegNacdTwArr;
    }

    public void setPlegNacdTwArr(String plegNacdTwArr) {
        this.plegNacdTwArr = plegNacdTwArr == null ? null : plegNacdTwArr.trim();
    }

    public String getPlegCkiCounterNo() {
        return plegCkiCounterNo;
    }

    public void setPlegCkiCounterNo(String plegCkiCounterNo) {
        this.plegCkiCounterNo = plegCkiCounterNo == null ? null : plegCkiCounterNo.trim();
    }

    public String getPlegCkiCounterNoI() {
        return plegCkiCounterNoI;
    }

    public void setPlegCkiCounterNoI(String plegCkiCounterNoI) {
        this.plegCkiCounterNoI = plegCkiCounterNoI == null ? null : plegCkiCounterNoI.trim();
    }

    public String getPlegWaitBrdRegionD() {
        return plegWaitBrdRegionD;
    }

    public void setPlegWaitBrdRegionD(String plegWaitBrdRegionD) {
        this.plegWaitBrdRegionD = plegWaitBrdRegionD == null ? null : plegWaitBrdRegionD.trim();
    }

    public String getPlegWaitBrdRegionI() {
        return plegWaitBrdRegionI;
    }

    public void setPlegWaitBrdRegionI(String plegWaitBrdRegionI) {
        this.plegWaitBrdRegionI = plegWaitBrdRegionI == null ? null : plegWaitBrdRegionI.trim();
    }

    public String getPlegBrdGateD() {
        return plegBrdGateD;
    }

    public void setPlegBrdGateD(String plegBrdGateD) {
        this.plegBrdGateD = plegBrdGateD == null ? null : plegBrdGateD.trim();
    }

    public String getPlegBrdGateF() {
        return plegBrdGateF;
    }

    public void setPlegBrdGateF(String plegBrdGateF) {
        this.plegBrdGateF = plegBrdGateF == null ? null : plegBrdGateF.trim();
    }

    public String getPlegBrdGateI() {
        return plegBrdGateI;
    }

    public void setPlegBrdGateI(String plegBrdGateI) {
        this.plegBrdGateI = plegBrdGateI == null ? null : plegBrdGateI.trim();
    }

    public LocalDateTime getPlegOpTm() {
        return plegOpTm;
    }

    public void setPlegOpTm(LocalDateTime plegOpTm) {
        this.plegOpTm = plegOpTm;
    }

    public LocalDateTime getPlegTmAllowBrd() {
        return plegTmAllowBrd;
    }

    public void setPlegTmAllowBrd(LocalDateTime plegTmAllowBrd) {
        this.plegTmAllowBrd = plegTmAllowBrd;
    }

    public LocalDateTime getPlegTmPullon() {
        return plegTmPullon;
    }

    public void setPlegTmPullon(LocalDateTime plegTmPullon) {
        this.plegTmPullon = plegTmPullon;
    }

    public LocalDateTime getPlegTmPulloff() {
        return plegTmPulloff;
    }

    public void setPlegTmPulloff(LocalDateTime plegTmPulloff) {
        this.plegTmPulloff = plegTmPulloff;
    }

    public LocalDateTime getPlegTmCloseDoor() {
        return plegTmCloseDoor;
    }

    public void setPlegTmCloseDoor(LocalDateTime plegTmCloseDoor) {
        this.plegTmCloseDoor = plegTmCloseDoor;
    }

    public LocalDateTime getPlegTmOpenDoor() {
        return plegTmOpenDoor;
    }

    public void setPlegTmOpenDoor(LocalDateTime plegTmOpenDoor) {
        this.plegTmOpenDoor = plegTmOpenDoor;
    }

    public LocalDateTime getPlegTmPullout() {
        return plegTmPullout;
    }

    public void setPlegTmPullout(LocalDateTime plegTmPullout) {
        this.plegTmPullout = plegTmPullout;
    }

    public LocalDateTime getPlegCopTmD() {
        return plegCopTmD;
    }

    public void setPlegCopTmD(LocalDateTime plegCopTmD) {
        this.plegCopTmD = plegCopTmD;
    }

    public LocalDateTime getPlegCopTmI() {
        return plegCopTmI;
    }

    public void setPlegCopTmI(LocalDateTime plegCopTmI) {
        this.plegCopTmI = plegCopTmI;
    }

    public LocalDateTime getPlegTmCkiBeginD() {
        return plegTmCkiBeginD;
    }

    public void setPlegTmCkiBeginD(LocalDateTime plegTmCkiBeginD) {
        this.plegTmCkiBeginD = plegTmCkiBeginD;
    }

    public LocalDateTime getPlegTmCkiBeginI() {
        return plegTmCkiBeginI;
    }

    public void setPlegTmCkiBeginI(LocalDateTime plegTmCkiBeginI) {
        this.plegTmCkiBeginI = plegTmCkiBeginI;
    }

    public LocalDateTime getPlegTmCclD() {
        return plegTmCclD;
    }

    public void setPlegTmCclD(LocalDateTime plegTmCclD) {
        this.plegTmCclD = plegTmCclD;
    }

    public LocalDateTime getPlegTmCclI() {
        return plegTmCclI;
    }

    public void setPlegTmCclI(LocalDateTime plegTmCclI) {
        this.plegTmCclI = plegTmCclI;
    }

    public LocalDateTime getPlegTmOgClose() {
        return plegTmOgClose;
    }

    public void setPlegTmOgClose(LocalDateTime plegTmOgClose) {
        this.plegTmOgClose = plegTmOgClose;
    }

    public LocalDateTime getPlegTmCi() {
        return plegTmCi;
    }

    public void setPlegTmCi(LocalDateTime plegTmCi) {
        this.plegTmCi = plegTmCi;
    }

    public LocalDateTime getPlegTmCcl() {
        return plegTmCcl;
    }

    public void setPlegTmCcl(LocalDateTime plegTmCcl) {
        this.plegTmCcl = plegTmCcl;
    }

    public LocalDateTime getPlegTmBrdD() {
        return plegTmBrdD;
    }

    public void setPlegTmBrdD(LocalDateTime plegTmBrdD) {
        this.plegTmBrdD = plegTmBrdD;
    }

    public LocalDateTime getPlegTmBrdI() {
        return plegTmBrdI;
    }

    public void setPlegTmBrdI(LocalDateTime plegTmBrdI) {
        this.plegTmBrdI = plegTmBrdI;
    }

    public LocalDateTime getPlegTmBrdCnlD() {
        return plegTmBrdCnlD;
    }

    public void setPlegTmBrdCnlD(LocalDateTime plegTmBrdCnlD) {
        this.plegTmBrdCnlD = plegTmBrdCnlD;
    }

    public LocalDateTime getPlegTmBrdCnlI() {
        return plegTmBrdCnlI;
    }

    public void setPlegTmBrdCnlI(LocalDateTime plegTmBrdCnlI) {
        this.plegTmBrdCnlI = plegTmBrdCnlI;
    }

    public LocalDateTime getPlegTmPsaD() {
        return plegTmPsaD;
    }

    public void setPlegTmPsaD(LocalDateTime plegTmPsaD) {
        this.plegTmPsaD = plegTmPsaD;
    }

    public LocalDateTime getPlegTmPsaI() {
        return plegTmPsaI;
    }

    public void setPlegTmPsaI(LocalDateTime plegTmPsaI) {
        this.plegTmPsaI = plegTmPsaI;
    }

    public LocalDateTime getPlegTmPsaAfer() {
        return plegTmPsaAfer;
    }

    public void setPlegTmPsaAfer(LocalDateTime plegTmPsaAfer) {
        this.plegTmPsaAfer = plegTmPsaAfer;
    }

    public LocalDateTime getPlegTmCiD() {
        return plegTmCiD;
    }

    public void setPlegTmCiD(LocalDateTime plegTmCiD) {
        this.plegTmCiD = plegTmCiD;
    }

    public LocalDateTime getPlegTmCiI() {
        return plegTmCiI;
    }

    public void setPlegTmCiI(LocalDateTime plegTmCiI) {
        this.plegTmCiI = plegTmCiI;
    }

    public LocalDateTime getPlegTmInChannel() {
        return plegTmInChannel;
    }

    public void setPlegTmInChannel(LocalDateTime plegTmInChannel) {
        this.plegTmInChannel = plegTmInChannel;
    }

    public LocalDateTime getPlegTmPullInto() {
        return plegTmPullInto;
    }

    public void setPlegTmPullInto(LocalDateTime plegTmPullInto) {
        this.plegTmPullInto = plegTmPullInto;
    }

    public LocalDateTime getPlegTmPtd() {
        return plegTmPtd;
    }

    public void setPlegTmPtd(LocalDateTime plegTmPtd) {
        this.plegTmPtd = plegTmPtd;
    }

    public LocalDateTime getPlegTmEtd() {
        return plegTmEtd;
    }

    public void setPlegTmEtd(LocalDateTime plegTmEtd) {
        this.plegTmEtd = plegTmEtd;
    }

    public LocalDateTime getPlegTmAtd() {
        return plegTmAtd;
    }

    public void setPlegTmAtd(LocalDateTime plegTmAtd) {
        this.plegTmAtd = plegTmAtd;
    }

    public LocalDateTime getPlegTmPta() {
        return plegTmPta;
    }

    public void setPlegTmPta(LocalDateTime plegTmPta) {
        this.plegTmPta = plegTmPta;
    }

    public LocalDateTime getPlegTmEta() {
        return plegTmEta;
    }

    public void setPlegTmEta(LocalDateTime plegTmEta) {
        this.plegTmEta = plegTmEta;
    }

    public LocalDateTime getPlegTmAta() {
        return plegTmAta;
    }

    public void setPlegTmAta(LocalDateTime plegTmAta) {
        this.plegTmAta = plegTmAta;
    }

    public String getPlegBagTransGateArr() {
        return plegBagTransGateArr;
    }

    public void setPlegBagTransGateArr(String plegBagTransGateArr) {
        this.plegBagTransGateArr = plegBagTransGateArr == null ? null : plegBagTransGateArr.trim();
    }

    public String getPlegBagTransGateDep() {
        return plegBagTransGateDep;
    }

    public void setPlegBagTransGateDep(String plegBagTransGateDep) {
        this.plegBagTransGateDep = plegBagTransGateDep == null ? null : plegBagTransGateDep.trim();
    }

    public String getPlegBagTransBeltArr() {
        return plegBagTransBeltArr;
    }

    public void setPlegBagTransBeltArr(String plegBagTransBeltArr) {
        this.plegBagTransBeltArr = plegBagTransBeltArr == null ? null : plegBagTransBeltArr.trim();
    }

    public String getPlegTransferBagInGate() {
        return plegTransferBagInGate;
    }

    public void setPlegTransferBagInGate(String plegTransferBagInGate) {
        this.plegTransferBagInGate = plegTransferBagInGate == null ? null : plegTransferBagInGate.trim();
    }

    public String getPlegUpcpApThr() {
        return plegUpcpApThr;
    }

    public void setPlegUpcpApThr(String plegUpcpApThr) {
        this.plegUpcpApThr = plegUpcpApThr == null ? null : plegUpcpApThr.trim();
    }

    public String getPlegUpcpFlt() {
        return plegUpcpFlt;
    }

    public void setPlegUpcpFlt(String plegUpcpFlt) {
        this.plegUpcpFlt = plegUpcpFlt == null ? null : plegUpcpFlt.trim();
    }

    public LocalDateTime getPlegTmPrePta() {
        return plegTmPrePta;
    }

    public void setPlegTmPrePta(LocalDateTime plegTmPrePta) {
        this.plegTmPrePta = plegTmPrePta;
    }

    public LocalDateTime getPlegTmPreEta() {
        return plegTmPreEta;
    }

    public void setPlegTmPreEta(LocalDateTime plegTmPreEta) {
        this.plegTmPreEta = plegTmPreEta;
    }

    public LocalDateTime getPlegTmPreAta() {
        return plegTmPreAta;
    }

    public void setPlegTmPreAta(LocalDateTime plegTmPreAta) {
        this.plegTmPreAta = plegTmPreAta;
    }

    public String getPlegCpApThr() {
        return plegCpApThr;
    }

    public void setPlegCpApThr(String plegCpApThr) {
        this.plegCpApThr = plegCpApThr == null ? null : plegCpApThr.trim();
    }

    public String getPlegCpflt() {
        return plegCpflt;
    }

    public void setPlegCpflt(String plegCpflt) {
        this.plegCpflt = plegCpflt == null ? null : plegCpflt.trim();
    }

    public LocalDateTime getPlegTmNextPtd() {
        return plegTmNextPtd;
    }

    public void setPlegTmNextPtd(LocalDateTime plegTmNextPtd) {
        this.plegTmNextPtd = plegTmNextPtd;
    }

    public LocalDateTime getPlegTmNextEtd() {
        return plegTmNextEtd;
    }

    public void setPlegTmNextEtd(LocalDateTime plegTmNextEtd) {
        this.plegTmNextEtd = plegTmNextEtd;
    }

    public LocalDateTime getPlegTmNextAtd() {
        return plegTmNextAtd;
    }

    public void setPlegTmNextAtd(LocalDateTime plegTmNextAtd) {
        this.plegTmNextAtd = plegTmNextAtd;
    }

    public String getPlegShowFlag() {
        return plegShowFlag;
    }

    public void setPlegShowFlag(String plegShowFlag) {
        this.plegShowFlag = plegShowFlag == null ? null : plegShowFlag.trim();
    }

    public Byte getPlegPubFlag() {
        return plegPubFlag;
    }

    public void setPlegPubFlag(Byte plegPubFlag) {
        this.plegPubFlag = plegPubFlag;
    }

    public Byte getPlegParkType() {
        return plegParkType;
    }

    public void setPlegParkType(Byte plegParkType) {
        this.plegParkType = plegParkType;
    }

    public String getPlegPnumArr() {
        return plegPnumArr;
    }

    public void setPlegPnumArr(String plegPnumArr) {
        this.plegPnumArr = plegPnumArr == null ? null : plegPnumArr.trim();
    }

    public String getPlegPnumAcbArr() {
        return plegPnumAcbArr;
    }

    public void setPlegPnumAcbArr(String plegPnumAcbArr) {
        this.plegPnumAcbArr = plegPnumAcbArr == null ? null : plegPnumAcbArr.trim();
    }

    public String getPlegPsaNumD() {
        return plegPsaNumD;
    }

    public void setPlegPsaNumD(String plegPsaNumD) {
        this.plegPsaNumD = plegPsaNumD == null ? null : plegPsaNumD.trim();
    }

    public String getPlegPscNumD() {
        return plegPscNumD;
    }

    public void setPlegPscNumD(String plegPscNumD) {
        this.plegPscNumD = plegPscNumD == null ? null : plegPscNumD.trim();
    }

    public String getPlegPsaNumAcbD() {
        return plegPsaNumAcbD;
    }

    public void setPlegPsaNumAcbD(String plegPsaNumAcbD) {
        this.plegPsaNumAcbD = plegPsaNumAcbD == null ? null : plegPsaNumAcbD.trim();
    }

    public String getPlegPscNumAcbD() {
        return plegPscNumAcbD;
    }

    public void setPlegPscNumAcbD(String plegPscNumAcbD) {
        this.plegPscNumAcbD = plegPscNumAcbD == null ? null : plegPscNumAcbD.trim();
    }

    public String getPlegBagNumArrD() {
        return plegBagNumArrD;
    }

    public void setPlegBagNumArrD(String plegBagNumArrD) {
        this.plegBagNumArrD = plegBagNumArrD == null ? null : plegBagNumArrD.trim();
    }

    public String getPlegPsaBagD() {
        return plegPsaBagD;
    }

    public void setPlegPsaBagD(String plegPsaBagD) {
        this.plegPsaBagD = plegPsaBagD == null ? null : plegPsaBagD.trim();
    }

    public String getPlegPscBagD() {
        return plegPscBagD;
    }

    public void setPlegPscBagD(String plegPscBagD) {
        this.plegPscBagD = plegPscBagD == null ? null : plegPscBagD.trim();
    }

    public String getPlegPnumTransferArr() {
        return plegPnumTransferArr;
    }

    public void setPlegPnumTransferArr(String plegPnumTransferArr) {
        this.plegPnumTransferArr = plegPnumTransferArr == null ? null : plegPnumTransferArr.trim();
    }

    public String getPlegBagNumTransferArr() {
        return plegBagNumTransferArr;
    }

    public void setPlegBagNumTransferArr(String plegBagNumTransferArr) {
        this.plegBagNumTransferArr = plegBagNumTransferArr == null ? null : plegBagNumTransferArr.trim();
    }

    public String getPlegTransferPnum() {
        return plegTransferPnum;
    }

    public void setPlegTransferPnum(String plegTransferPnum) {
        this.plegTransferPnum = plegTransferPnum == null ? null : plegTransferPnum.trim();
    }

    public String getPlegTransferBagNum() {
        return plegTransferBagNum;
    }

    public void setPlegTransferBagNum(String plegTransferBagNum) {
        this.plegTransferBagNum = plegTransferBagNum == null ? null : plegTransferBagNum.trim();
    }

    public String getPlegTransferBagWeight() {
        return plegTransferBagWeight;
    }

    public void setPlegTransferBagWeight(String plegTransferBagWeight) {
        this.plegTransferBagWeight = plegTransferBagWeight == null ? null : plegTransferBagWeight.trim();
    }

    public String getPlegPnumArrI() {
        return plegPnumArrI;
    }

    public void setPlegPnumArrI(String plegPnumArrI) {
        this.plegPnumArrI = plegPnumArrI == null ? null : plegPnumArrI.trim();
    }

    public String getPlegPnumAcbArrI() {
        return plegPnumAcbArrI;
    }

    public void setPlegPnumAcbArrI(String plegPnumAcbArrI) {
        this.plegPnumAcbArrI = plegPnumAcbArrI == null ? null : plegPnumAcbArrI.trim();
    }

    public String getPlegPsaNumI() {
        return plegPsaNumI;
    }

    public void setPlegPsaNumI(String plegPsaNumI) {
        this.plegPsaNumI = plegPsaNumI == null ? null : plegPsaNumI.trim();
    }

    public String getPlegPscNumI() {
        return plegPscNumI;
    }

    public void setPlegPscNumI(String plegPscNumI) {
        this.plegPscNumI = plegPscNumI == null ? null : plegPscNumI.trim();
    }

    public String getPlegPsaNumAcbI() {
        return plegPsaNumAcbI;
    }

    public void setPlegPsaNumAcbI(String plegPsaNumAcbI) {
        this.plegPsaNumAcbI = plegPsaNumAcbI == null ? null : plegPsaNumAcbI.trim();
    }

    public String getPlegPscNumAcbI() {
        return plegPscNumAcbI;
    }

    public void setPlegPscNumAcbI(String plegPscNumAcbI) {
        this.plegPscNumAcbI = plegPscNumAcbI == null ? null : plegPscNumAcbI.trim();
    }

    public String getPlegBagNumArrI() {
        return plegBagNumArrI;
    }

    public void setPlegBagNumArrI(String plegBagNumArrI) {
        this.plegBagNumArrI = plegBagNumArrI == null ? null : plegBagNumArrI.trim();
    }

    public String getPlegPsaBagI() {
        return plegPsaBagI;
    }

    public void setPlegPsaBagI(String plegPsaBagI) {
        this.plegPsaBagI = plegPsaBagI == null ? null : plegPsaBagI.trim();
    }

    public String getPlegPscBagI() {
        return plegPscBagI;
    }

    public void setPlegPscBagI(String plegPscBagI) {
        this.plegPscBagI = plegPscBagI == null ? null : plegPscBagI.trim();
    }

    public String getPlegLoadBagNumI() {
        return plegLoadBagNumI;
    }

    public void setPlegLoadBagNumI(String plegLoadBagNumI) {
        this.plegLoadBagNumI = plegLoadBagNumI == null ? null : plegLoadBagNumI.trim();
    }

    public String getPlegGzNum() {
        return plegGzNum;
    }

    public void setPlegGzNum(String plegGzNum) {
        this.plegGzNum = plegGzNum == null ? null : plegGzNum.trim();
    }

    public String getPlegGzNumAcb() {
        return plegGzNumAcb;
    }

    public void setPlegGzNumAcb(String plegGzNumAcb) {
        this.plegGzNumAcb = plegGzNumAcb == null ? null : plegGzNumAcb.trim();
    }

    public String getPlegGzBag() {
        return plegGzBag;
    }

    public void setPlegGzBag(String plegGzBag) {
        this.plegGzBag = plegGzBag == null ? null : plegGzBag.trim();
    }

    public String getPlegResPnum() {
        return plegResPnum;
    }

    public void setPlegResPnum(String plegResPnum) {
        this.plegResPnum = plegResPnum == null ? null : plegResPnum.trim();
    }

    public String getPlegResPnumAcb() {
        return plegResPnumAcb;
    }

    public void setPlegResPnumAcb(String plegResPnumAcb) {
        this.plegResPnumAcb = plegResPnumAcb == null ? null : plegResPnumAcb.trim();
    }

    public String getPlegResBagD() {
        return plegResBagD;
    }

    public void setPlegResBagD(String plegResBagD) {
        this.plegResBagD = plegResBagD == null ? null : plegResBagD.trim();
    }

    public String getPlegResPnumI() {
        return plegResPnumI;
    }

    public void setPlegResPnumI(String plegResPnumI) {
        this.plegResPnumI = plegResPnumI == null ? null : plegResPnumI.trim();
    }

    public String getPlegResPnumAcbI() {
        return plegResPnumAcbI;
    }

    public void setPlegResPnumAcbI(String plegResPnumAcbI) {
        this.plegResPnumAcbI = plegResPnumAcbI == null ? null : plegResPnumAcbI.trim();
    }

    public String getPlegResBagI() {
        return plegResBagI;
    }

    public void setPlegResBagI(String plegResBagI) {
        this.plegResBagI = plegResBagI == null ? null : plegResBagI.trim();
    }

    public String getPlegOgNumD() {
        return plegOgNumD;
    }

    public void setPlegOgNumD(String plegOgNumD) {
        this.plegOgNumD = plegOgNumD == null ? null : plegOgNumD.trim();
    }

    public String getPlegOgBagD() {
        return plegOgBagD;
    }

    public void setPlegOgBagD(String plegOgBagD) {
        this.plegOgBagD = plegOgBagD == null ? null : plegOgBagD.trim();
    }

    public String getPlegOgNumI() {
        return plegOgNumI;
    }

    public void setPlegOgNumI(String plegOgNumI) {
        this.plegOgNumI = plegOgNumI == null ? null : plegOgNumI.trim();
    }

    public String getPlegOgBagI() {
        return plegOgBagI;
    }

    public void setPlegOgBagI(String plegOgBagI) {
        this.plegOgBagI = plegOgBagI == null ? null : plegOgBagI.trim();
    }

    public String getPlegOgNumAcbD() {
        return plegOgNumAcbD;
    }

    public void setPlegOgNumAcbD(String plegOgNumAcbD) {
        this.plegOgNumAcbD = plegOgNumAcbD == null ? null : plegOgNumAcbD.trim();
    }

    public String getPlegOgNumAcbI() {
        return plegOgNumAcbI;
    }

    public void setPlegOgNumAcbI(String plegOgNumAcbI) {
        this.plegOgNumAcbI = plegOgNumAcbI == null ? null : plegOgNumAcbI.trim();
    }

    public String getPlegLdmPsrFcy() {
        return plegLdmPsrFcy;
    }

    public void setPlegLdmPsrFcy(String plegLdmPsrFcy) {
        this.plegLdmPsrFcy = plegLdmPsrFcy == null ? null : plegLdmPsrFcy.trim();
    }

    public String getPlegLdmBag() {
        return plegLdmBag;
    }

    public void setPlegLdmBag(String plegLdmBag) {
        this.plegLdmBag = plegLdmBag == null ? null : plegLdmBag.trim();
    }

    public String getPlegLdmPsrTrsfFcy() {
        return plegLdmPsrTrsfFcy;
    }

    public void setPlegLdmPsrTrsfFcy(String plegLdmPsrTrsfFcy) {
        this.plegLdmPsrTrsfFcy = plegLdmPsrTrsfFcy == null ? null : plegLdmPsrTrsfFcy.trim();
    }

    public String getPlegLdmPsrTrsfAcb() {
        return plegLdmPsrTrsfAcb;
    }

    public void setPlegLdmPsrTrsfAcb(String plegLdmPsrTrsfAcb) {
        this.plegLdmPsrTrsfAcb = plegLdmPsrTrsfAcb == null ? null : plegLdmPsrTrsfAcb.trim();
    }

    public String getPlegLdmPsrAcb() {
        return plegLdmPsrAcb;
    }

    public void setPlegLdmPsrAcb(String plegLdmPsrAcb) {
        this.plegLdmPsrAcb = plegLdmPsrAcb == null ? null : plegLdmPsrAcb.trim();
    }

    public String getPlegLdmBagTrsf() {
        return plegLdmBagTrsf;
    }

    public void setPlegLdmBagTrsf(String plegLdmBagTrsf) {
        this.plegLdmBagTrsf = plegLdmBagTrsf == null ? null : plegLdmBagTrsf.trim();
    }

    public Byte getPlegLdmFlag() {
        return plegLdmFlag;
    }

    public void setPlegLdmFlag(Byte plegLdmFlag) {
        this.plegLdmFlag = plegLdmFlag;
    }

    public Byte getPlegLdmStatus() {
        return plegLdmStatus;
    }

    public void setPlegLdmStatus(Byte plegLdmStatus) {
        this.plegLdmStatus = plegLdmStatus;
    }

    public String getPlegResAdultFcy() {
        return plegResAdultFcy;
    }

    public void setPlegResAdultFcy(String plegResAdultFcy) {
        this.plegResAdultFcy = plegResAdultFcy == null ? null : plegResAdultFcy.trim();
    }

    public String getPlegResChildFcy() {
        return plegResChildFcy;
    }

    public void setPlegResChildFcy(String plegResChildFcy) {
        this.plegResChildFcy = plegResChildFcy == null ? null : plegResChildFcy.trim();
    }

    public String getPlegResInfantFcy() {
        return plegResInfantFcy;
    }

    public void setPlegResInfantFcy(String plegResInfantFcy) {
        this.plegResInfantFcy = plegResInfantFcy == null ? null : plegResInfantFcy.trim();
    }

    public String getPlegCkiAdultFcy() {
        return plegCkiAdultFcy;
    }

    public void setPlegCkiAdultFcy(String plegCkiAdultFcy) {
        this.plegCkiAdultFcy = plegCkiAdultFcy == null ? null : plegCkiAdultFcy.trim();
    }

    public String getPlegCkiChildFcy() {
        return plegCkiChildFcy;
    }

    public void setPlegCkiChildFcy(String plegCkiChildFcy) {
        this.plegCkiChildFcy = plegCkiChildFcy == null ? null : plegCkiChildFcy.trim();
    }

    public String getPlegCkiInfantFcy() {
        return plegCkiInfantFcy;
    }

    public void setPlegCkiInfantFcy(String plegCkiInfantFcy) {
        this.plegCkiInfantFcy = plegCkiInfantFcy == null ? null : plegCkiInfantFcy.trim();
    }

    public String getPlegBrdAdultFcy() {
        return plegBrdAdultFcy;
    }

    public void setPlegBrdAdultFcy(String plegBrdAdultFcy) {
        this.plegBrdAdultFcy = plegBrdAdultFcy == null ? null : plegBrdAdultFcy.trim();
    }

    public String getPlegBrdChildFcy() {
        return plegBrdChildFcy;
    }

    public void setPlegBrdChildFcy(String plegBrdChildFcy) {
        this.plegBrdChildFcy = plegBrdChildFcy == null ? null : plegBrdChildFcy.trim();
    }

    public String getPlegBrdInfantFcy() {
        return plegBrdInfantFcy;
    }

    public void setPlegBrdInfantFcy(String plegBrdInfantFcy) {
        this.plegBrdInfantFcy = plegBrdInfantFcy == null ? null : plegBrdInfantFcy.trim();
    }

    public String getPlegBggUnit() {
        return plegBggUnit;
    }

    public void setPlegBggUnit(String plegBggUnit) {
        this.plegBggUnit = plegBggUnit == null ? null : plegBggUnit.trim();
    }

    public String getPlegBggWeight() {
        return plegBggWeight;
    }

    public void setPlegBggWeight(String plegBggWeight) {
        this.plegBggWeight = plegBggWeight == null ? null : plegBggWeight.trim();
    }

    public String getPlegCgoWeight() {
        return plegCgoWeight;
    }

    public void setPlegCgoWeight(String plegCgoWeight) {
        this.plegCgoWeight = plegCgoWeight == null ? null : plegCgoWeight.trim();
    }

    public String getPlegMailWeight() {
        return plegMailWeight;
    }

    public void setPlegMailWeight(String plegMailWeight) {
        this.plegMailWeight = plegMailWeight == null ? null : plegMailWeight.trim();
    }

    public String getPlegTotalWeight() {
        return plegTotalWeight;
    }

    public void setPlegTotalWeight(String plegTotalWeight) {
        this.plegTotalWeight = plegTotalWeight == null ? null : plegTotalWeight.trim();
    }

    public String getPlegDelayReview() {
        return plegDelayReview;
    }

    public void setPlegDelayReview(String plegDelayReview) {
        this.plegDelayReview = plegDelayReview == null ? null : plegDelayReview.trim();
    }

    public String getSwisId() {
        return swisId;
    }

    public void setSwisId(String swisId) {
        this.swisId = swisId == null ? null : swisId.trim();
    }

    public String getPlegApThrArrAll() {
        return plegApThrArrAll;
    }

    public void setPlegApThrArrAll(String plegApThrArrAll) {
        this.plegApThrArrAll = plegApThrArrAll == null ? null : plegApThrArrAll.trim();
    }

    public String getPlegApThrDepAll() {
        return plegApThrDepAll;
    }

    public void setPlegApThrDepAll(String plegApThrDepAll) {
        this.plegApThrDepAll = plegApThrDepAll == null ? null : plegApThrDepAll.trim();
    }

    public String getPlegBrdGateDDcs() {
        return plegBrdGateDDcs;
    }

    public void setPlegBrdGateDDcs(String plegBrdGateDDcs) {
        this.plegBrdGateDDcs = plegBrdGateDDcs == null ? null : plegBrdGateDDcs.trim();
    }

    public String getPlegBrdGateIDcs() {
        return plegBrdGateIDcs;
    }

    public void setPlegBrdGateIDcs(String plegBrdGateIDcs) {
        this.plegBrdGateIDcs = plegBrdGateIDcs == null ? null : plegBrdGateIDcs.trim();
    }

    public String getPlegCkiStatus() {
        return plegCkiStatus;
    }

    public void setPlegCkiStatus(String plegCkiStatus) {
        this.plegCkiStatus = plegCkiStatus == null ? null : plegCkiStatus.trim();
    }

    public String getPlegTransferStatus() {
        return plegTransferStatus;
    }

    public void setPlegTransferStatus(String plegTransferStatus) {
        this.plegTransferStatus = plegTransferStatus == null ? null : plegTransferStatus.trim();
    }

    public String getPlegGsLimited() {
        return plegGsLimited;
    }

    public void setPlegGsLimited(String plegGsLimited) {
        this.plegGsLimited = plegGsLimited == null ? null : plegGsLimited.trim();
    }

    public String getPlegWaitRoom() {
        return plegWaitRoom;
    }

    public void setPlegWaitRoom(String plegWaitRoom) {
        this.plegWaitRoom = plegWaitRoom == null ? null : plegWaitRoom.trim();
    }

    public String getPlegArrGate() {
        return plegArrGate;
    }

    public void setPlegArrGate(String plegArrGate) {
        this.plegArrGate = plegArrGate == null ? null : plegArrGate.trim();
    }

    public String getPlegArrRoom() {
        return plegArrRoom;
    }

    public void setPlegArrRoom(String plegArrRoom) {
        this.plegArrRoom = plegArrRoom == null ? null : plegArrRoom.trim();
    }

    public String getPlegPnumResAll() {
        return plegPnumResAll;
    }

    public void setPlegPnumResAll(String plegPnumResAll) {
        this.plegPnumResAll = plegPnumResAll == null ? null : plegPnumResAll.trim();
    }

    public String getPlegPnumCkiAll() {
        return plegPnumCkiAll;
    }

    public void setPlegPnumCkiAll(String plegPnumCkiAll) {
        this.plegPnumCkiAll = plegPnumCkiAll == null ? null : plegPnumCkiAll.trim();
    }

    public String getPlegPnumBrdAll() {
        return plegPnumBrdAll;
    }

    public void setPlegPnumBrdAll(String plegPnumBrdAll) {
        this.plegPnumBrdAll = plegPnumBrdAll == null ? null : plegPnumBrdAll.trim();
    }

    public LocalDateTime getPlegVipsvcTime() {
        return plegVipsvcTime;
    }

    public void setPlegVipsvcTime(LocalDateTime plegVipsvcTime) {
        this.plegVipsvcTime = plegVipsvcTime;
    }

    public LocalDateTime getPlegSpcsvcTime() {
        return plegSpcsvcTime;
    }

    public void setPlegSpcsvcTime(LocalDateTime plegSpcsvcTime) {
        this.plegSpcsvcTime = plegSpcsvcTime;
    }

    public String getPlegFplFlightTime() {
        return plegFplFlightTime;
    }

    public void setPlegFplFlightTime(String plegFplFlightTime) {
        this.plegFplFlightTime = plegFplFlightTime == null ? null : plegFplFlightTime.trim();
    }

    public String getPlegCaptNum() {
        return plegCaptNum;
    }

    public void setPlegCaptNum(String plegCaptNum) {
        this.plegCaptNum = plegCaptNum == null ? null : plegCaptNum.trim();
    }

    public String getPlegAirBridge() {
        return plegAirBridge;
    }

    public void setPlegAirBridge(String plegAirBridge) {
        this.plegAirBridge = plegAirBridge == null ? null : plegAirBridge.trim();
    }

    public String getPlegBagExchangeNum() {
        return plegBagExchangeNum;
    }

    public void setPlegBagExchangeNum(String plegBagExchangeNum) {
        this.plegBagExchangeNum = plegBagExchangeNum == null ? null : plegBagExchangeNum.trim();
    }

    public String getPlegBagExchangeWeight() {
        return plegBagExchangeWeight;
    }

    public void setPlegBagExchangeWeight(String plegBagExchangeWeight) {
        this.plegBagExchangeWeight = plegBagExchangeWeight == null ? null : plegBagExchangeWeight.trim();
    }

    public String getPlegPaxThroughNum() {
        return plegPaxThroughNum;
    }

    public void setPlegPaxThroughNum(String plegPaxThroughNum) {
        this.plegPaxThroughNum = plegPaxThroughNum == null ? null : plegPaxThroughNum.trim();
    }

    public String getPlegBagThroughNum() {
        return plegBagThroughNum;
    }

    public void setPlegBagThroughNum(String plegBagThroughNum) {
        this.plegBagThroughNum = plegBagThroughNum == null ? null : plegBagThroughNum.trim();
    }

    public String getPlegBagThroughWeight() {
        return plegBagThroughWeight;
    }

    public void setPlegBagThroughWeight(String plegBagThroughWeight) {
        this.plegBagThroughWeight = plegBagThroughWeight == null ? null : plegBagThroughWeight.trim();
    }

    public String getPlegChildAloneNum() {
        return plegChildAloneNum;
    }

    public void setPlegChildAloneNum(String plegChildAloneNum) {
        this.plegChildAloneNum = plegChildAloneNum == null ? null : plegChildAloneNum.trim();
    }

    public String getPlegElderAloneNum() {
        return plegElderAloneNum;
    }

    public void setPlegElderAloneNum(String plegElderAloneNum) {
        this.plegElderAloneNum = plegElderAloneNum == null ? null : plegElderAloneNum.trim();
    }

    public String getPlegPaxWhchNum() {
        return plegPaxWhchNum;
    }

    public void setPlegPaxWhchNum(String plegPaxWhchNum) {
        this.plegPaxWhchNum = plegPaxWhchNum == null ? null : plegPaxWhchNum.trim();
    }

    public String getPlegPaxBlndNum() {
        return plegPaxBlndNum;
    }

    public void setPlegPaxBlndNum(String plegPaxBlndNum) {
        this.plegPaxBlndNum = plegPaxBlndNum == null ? null : plegPaxBlndNum.trim();
    }

    public String getPlegBagNotdoneNum() {
        return plegBagNotdoneNum;
    }

    public void setPlegBagNotdoneNum(String plegBagNotdoneNum) {
        this.plegBagNotdoneNum = plegBagNotdoneNum == null ? null : plegBagNotdoneNum.trim();
    }

    public String getPlegHandbagNum() {
        return plegHandbagNum;
    }

    public void setPlegHandbagNum(String plegHandbagNum) {
        this.plegHandbagNum = plegHandbagNum == null ? null : plegHandbagNum.trim();
    }

    public String getPlegBagNotdoneWeight() {
        return plegBagNotdoneWeight;
    }

    public void setPlegBagNotdoneWeight(String plegBagNotdoneWeight) {
        this.plegBagNotdoneWeight = plegBagNotdoneWeight == null ? null : plegBagNotdoneWeight.trim();
    }

    public String getPlegHandbagWht() {
        return plegHandbagWht;
    }

    public void setPlegHandbagWht(String plegHandbagWht) {
        this.plegHandbagWht = plegHandbagWht == null ? null : plegHandbagWht.trim();
    }

    public String getPlegBagFancangNum() {
        return plegBagFancangNum;
    }

    public void setPlegBagFancangNum(String plegBagFancangNum) {
        this.plegBagFancangNum = plegBagFancangNum == null ? null : plegBagFancangNum.trim();
    }

    public String getPlegBagFancangWeight() {
        return plegBagFancangWeight;
    }

    public void setPlegBagFancangWeight(String plegBagFancangWeight) {
        this.plegBagFancangWeight = plegBagFancangWeight == null ? null : plegBagFancangWeight.trim();
    }

    public String getPlegBagCutNum() {
        return plegBagCutNum;
    }

    public void setPlegBagCutNum(String plegBagCutNum) {
        this.plegBagCutNum = plegBagCutNum == null ? null : plegBagCutNum.trim();
    }

    public String getPlegBagCutWeight() {
        return plegBagCutWeight;
    }

    public void setPlegBagCutWeight(String plegBagCutWeight) {
        this.plegBagCutWeight = plegBagCutWeight == null ? null : plegBagCutWeight.trim();
    }

    public String getPlegBagDelayNum() {
        return plegBagDelayNum;
    }

    public void setPlegBagDelayNum(String plegBagDelayNum) {
        this.plegBagDelayNum = plegBagDelayNum == null ? null : plegBagDelayNum.trim();
    }

    public String getPlegBagDelayWeight() {
        return plegBagDelayWeight;
    }

    public void setPlegBagDelayWeight(String plegBagDelayWeight) {
        this.plegBagDelayWeight = plegBagDelayWeight == null ? null : plegBagDelayWeight.trim();
    }

    public String getPlegPaxDeafNum() {
        return plegPaxDeafNum;
    }

    public void setPlegPaxDeafNum(String plegPaxDeafNum) {
        this.plegPaxDeafNum = plegPaxDeafNum == null ? null : plegPaxDeafNum.trim();
    }

    public String getPlegPaxFltWhchNum() {
        return plegPaxFltWhchNum;
    }

    public void setPlegPaxFltWhchNum(String plegPaxFltWhchNum) {
        this.plegPaxFltWhchNum = plegPaxFltWhchNum == null ? null : plegPaxFltWhchNum.trim();
    }

    public String getPlegOtherNum() {
        return plegOtherNum;
    }

    public void setPlegOtherNum(String plegOtherNum) {
        this.plegOtherNum = plegOtherNum == null ? null : plegOtherNum.trim();
    }

    public String getPlegChildAloneTnum() {
        return plegChildAloneTnum;
    }

    public void setPlegChildAloneTnum(String plegChildAloneTnum) {
        this.plegChildAloneTnum = plegChildAloneTnum == null ? null : plegChildAloneTnum.trim();
    }

    public String getPlegElderAloneTnum() {
        return plegElderAloneTnum;
    }

    public void setPlegElderAloneTnum(String plegElderAloneTnum) {
        this.plegElderAloneTnum = plegElderAloneTnum == null ? null : plegElderAloneTnum.trim();
    }

    public String getPlegPaxBlndTnum() {
        return plegPaxBlndTnum;
    }

    public void setPlegPaxBlndTnum(String plegPaxBlndTnum) {
        this.plegPaxBlndTnum = plegPaxBlndTnum == null ? null : plegPaxBlndTnum.trim();
    }

    public String getPlegPaxDeafTnum() {
        return plegPaxDeafTnum;
    }

    public void setPlegPaxDeafTnum(String plegPaxDeafTnum) {
        this.plegPaxDeafTnum = plegPaxDeafTnum == null ? null : plegPaxDeafTnum.trim();
    }

    public String getPlegPaxFltWhchTnum() {
        return plegPaxFltWhchTnum;
    }

    public void setPlegPaxFltWhchTnum(String plegPaxFltWhchTnum) {
        this.plegPaxFltWhchTnum = plegPaxFltWhchTnum == null ? null : plegPaxFltWhchTnum.trim();
    }

    public String getPlegPaxWhchTnum() {
        return plegPaxWhchTnum;
    }

    public void setPlegPaxWhchTnum(String plegPaxWhchTnum) {
        this.plegPaxWhchTnum = plegPaxWhchTnum == null ? null : plegPaxWhchTnum.trim();
    }

    public String getPlegOtherTnum() {
        return plegOtherTnum;
    }

    public void setPlegOtherTnum(String plegOtherTnum) {
        this.plegOtherTnum = plegOtherTnum == null ? null : plegOtherTnum.trim();
    }

    public String getPlegPaxStcrNum() {
        return plegPaxStcrNum;
    }

    public void setPlegPaxStcrNum(String plegPaxStcrNum) {
        this.plegPaxStcrNum = plegPaxStcrNum == null ? null : plegPaxStcrNum.trim();
    }

    public String getPlegTag() {
        return plegTag;
    }

    public void setPlegTag(String plegTag) {
        this.plegTag = plegTag == null ? null : plegTag.trim();
    }

    public Byte getPlegHasTsat() {
        return plegHasTsat;
    }

    public void setPlegHasTsat(Byte plegHasTsat) {
        this.plegHasTsat = plegHasTsat;
    }

    public String getPlegRegno() {
        return plegRegno;
    }

    public void setPlegRegno(String plegRegno) {
        this.plegRegno = plegRegno == null ? null : plegRegno.trim();
    }

    public String getPlegPlaneType() {
        return plegPlaneType;
    }

    public void setPlegPlaneType(String plegPlaneType) {
        this.plegPlaneType = plegPlaneType == null ? null : plegPlaneType.trim();
    }

    public String getPlegPlaneTypeThr() {
        return plegPlaneTypeThr;
    }

    public void setPlegPlaneTypeThr(String plegPlaneTypeThr) {
        this.plegPlaneTypeThr = plegPlaneTypeThr == null ? null : plegPlaneTypeThr.trim();
    }

    public Byte getPlegIskt() {
        return plegIskt;
    }

    public void setPlegIskt(Byte plegIskt) {
        this.plegIskt = plegIskt;
    }

    public String getPlegSeatConfig() {
        return plegSeatConfig;
    }

    public void setPlegSeatConfig(String plegSeatConfig) {
        this.plegSeatConfig = plegSeatConfig == null ? null : plegSeatConfig.trim();
    }

    public Byte getPlegIscargo() {
        return plegIscargo;
    }

    public void setPlegIscargo(Byte plegIscargo) {
        this.plegIscargo = plegIscargo;
    }

    public String getPlegRelFltNo() {
        return plegRelFltNo;
    }

    public void setPlegRelFltNo(String plegRelFltNo) {
        this.plegRelFltNo = plegRelFltNo == null ? null : plegRelFltNo.trim();
    }

    public String getPlegFltnoChg() {
        return plegFltnoChg;
    }

    public void setPlegFltnoChg(String plegFltnoChg) {
        this.plegFltnoChg = plegFltnoChg == null ? null : plegFltnoChg.trim();
    }

    public String getPlegBjc() {
        return plegBjc;
    }

    public void setPlegBjc(String plegBjc) {
        this.plegBjc = plegBjc == null ? null : plegBjc.trim();
    }

    public String getPlegBjcThr() {
        return plegBjcThr;
    }

    public void setPlegBjcThr(String plegBjcThr) {
        this.plegBjcThr = plegBjcThr == null ? null : plegBjcThr.trim();
    }

    public String getPlegFltMode() {
        return plegFltMode;
    }

    public void setPlegFltMode(String plegFltMode) {
        this.plegFltMode = plegFltMode == null ? null : plegFltMode.trim();
    }

    public String getPlegFltProp() {
        return plegFltProp;
    }

    public void setPlegFltProp(String plegFltProp) {
        this.plegFltProp = plegFltProp == null ? null : plegFltProp.trim();
    }

    public String getPlegTaskCode() {
        return plegTaskCode;
    }

    public void setPlegTaskCode(String plegTaskCode) {
        this.plegTaskCode = plegTaskCode == null ? null : plegTaskCode.trim();
    }

    public String getPlegShare() {
        return plegShare;
    }

    public void setPlegShare(String plegShare) {
        this.plegShare = plegShare == null ? null : plegShare.trim();
    }

    public String getPlegVirtualFlt() {
        return plegVirtualFlt;
    }

    public void setPlegVirtualFlt(String plegVirtualFlt) {
        this.plegVirtualFlt = plegVirtualFlt == null ? null : plegVirtualFlt.trim();
    }

    public String getPlegStations() {
        return plegStations;
    }

    public void setPlegStations(String plegStations) {
        this.plegStations = plegStations == null ? null : plegStations.trim();
    }

    public Byte getPlegNumStandby01() {
        return plegNumStandby01;
    }

    public void setPlegNumStandby01(Byte plegNumStandby01) {
        this.plegNumStandby01 = plegNumStandby01;
    }

    public Byte getPlegNumStandby02() {
        return plegNumStandby02;
    }

    public void setPlegNumStandby02(Byte plegNumStandby02) {
        this.plegNumStandby02 = plegNumStandby02;
    }

    public String getPlegStrStandby01() {
        return plegStrStandby01;
    }

    public void setPlegStrStandby01(String plegStrStandby01) {
        this.plegStrStandby01 = plegStrStandby01 == null ? null : plegStrStandby01.trim();
    }

    public String getPlegStrStandby02() {
        return plegStrStandby02;
    }

    public void setPlegStrStandby02(String plegStrStandby02) {
        this.plegStrStandby02 = plegStrStandby02 == null ? null : plegStrStandby02.trim();
    }

    public LocalDateTime getPlegTmStandby01() {
        return plegTmStandby01;
    }

    public void setPlegTmStandby01(LocalDateTime plegTmStandby01) {
        this.plegTmStandby01 = plegTmStandby01;
    }

    public LocalDateTime getPlegTmStandby02() {
        return plegTmStandby02;
    }

    public void setPlegTmStandby02(LocalDateTime plegTmStandby02) {
        this.plegTmStandby02 = plegTmStandby02;
    }

    public LocalDateTime getPlegTmStandby03() {
        return plegTmStandby03;
    }

    public void setPlegTmStandby03(LocalDateTime plegTmStandby03) {
        this.plegTmStandby03 = plegTmStandby03;
    }

    public LocalDateTime getPlegTmStandby04() {
        return plegTmStandby04;
    }

    public void setPlegTmStandby04(LocalDateTime plegTmStandby04) {
        this.plegTmStandby04 = plegTmStandby04;
    }

    public LocalDateTime getPlegTmStandby05() {
        return plegTmStandby05;
    }

    public void setPlegTmStandby05(LocalDateTime plegTmStandby05) {
        this.plegTmStandby05 = plegTmStandby05;
    }

    public LocalDateTime getPlegTmStandby06() {
        return plegTmStandby06;
    }

    public void setPlegTmStandby06(LocalDateTime plegTmStandby06) {
        this.plegTmStandby06 = plegTmStandby06;
    }

    public LocalDateTime getPlegTmStandby07() {
        return plegTmStandby07;
    }

    public void setPlegTmStandby07(LocalDateTime plegTmStandby07) {
        this.plegTmStandby07 = plegTmStandby07;
    }

    public LocalDateTime getPlegTmStandby08() {
        return plegTmStandby08;
    }

    public void setPlegTmStandby08(LocalDateTime plegTmStandby08) {
        this.plegTmStandby08 = plegTmStandby08;
    }

    public LocalDateTime getPlegTmStandby09() {
        return plegTmStandby09;
    }

    public void setPlegTmStandby09(LocalDateTime plegTmStandby09) {
        this.plegTmStandby09 = plegTmStandby09;
    }

    public LocalDateTime getPlegTmStandby10() {
        return plegTmStandby10;
    }

    public void setPlegTmStandby10(LocalDateTime plegTmStandby10) {
        this.plegTmStandby10 = plegTmStandby10;
    }

    public LocalDateTime getPlegTmStandby11() {
        return plegTmStandby11;
    }

    public void setPlegTmStandby11(LocalDateTime plegTmStandby11) {
        this.plegTmStandby11 = plegTmStandby11;
    }

    public LocalDateTime getPlegTmStandby12() {
        return plegTmStandby12;
    }

    public void setPlegTmStandby12(LocalDateTime plegTmStandby12) {
        this.plegTmStandby12 = plegTmStandby12;
    }

    public Long getFtrgId() {
        return ftrgId;
    }

    public void setFtrgId(Long ftrgId) {
        this.ftrgId = ftrgId;
    }

    public Byte getPlegTypeAD() {
        return plegTypeAD;
    }

    public void setPlegTypeAD(Byte plegTypeAD) {
        this.plegTypeAD = plegTypeAD;
    }
}