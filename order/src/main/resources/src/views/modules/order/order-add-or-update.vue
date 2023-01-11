<template>
  <el-dialog
      :close-on-click-modal="false"
      :title="!dataForm.id ? '新增' : '修改'"
      :visible.sync="visible">
    <el-form ref="dataForm" :model="dataForm" :rules="dataRule" label-width="80px"
             @keyup.enter.native="dataFormSubmit()">
      <el-form-item label="member_id" prop="memberId">
        <el-input v-model="dataForm.memberId" placeholder="member_id"></el-input>
      </el-form-item>
      <el-form-item label="order number" prop="orderSn">
        <el-input v-model="dataForm.orderSn" placeholder="order number"></el-input>
      </el-form-item>
      <el-form-item label="" prop="couponId">
        <el-input v-model="dataForm.couponId" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="createTime">
        <el-input v-model="dataForm.createTime" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="memberUsername">
        <el-input v-model="dataForm.memberUsername" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="Total payment" prop="totalAmount">
        <el-input v-model="dataForm.totalAmount" placeholder="Total payment"></el-input>
      </el-form-item>
      <el-form-item label="The payment we need to pay" prop="payAmount">
        <el-input v-model="dataForm.payAmount" placeholder="The payment we need to pay"></el-input>
      </el-form-item>
      <el-form-item label="postage" prop="freightAmount">
        <el-input v-model="dataForm.freightAmount" placeholder="postage"></el-input>
      </el-form-item>
      <el-form-item label="promotion" prop="promotionAmount">
        <el-input v-model="dataForm.promotionAmount" placeholder="promotion"></el-input>
      </el-form-item>
      <el-form-item label="" prop="integrationAmount">
        <el-input v-model="dataForm.integrationAmount" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="couponAmount">
        <el-input v-model="dataForm.couponAmount" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="discountAmount">
        <el-input v-model="dataForm.discountAmount" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="1 alipay 2 wechat pay 3 China Unionpay 4 payon delivery" prop="payType">
        <el-input v-model="dataForm.payType"
                  placeholder="1 alipay 2 wechat pay 3 China Unionpay 4 payon delivery"></el-input>
      </el-form-item>
      <el-form-item label="0: PC 1: APP" prop="sourceType">
        <el-input v-model="dataForm.sourceType" placeholder="0: PC 1: APP"></el-input>
      </el-form-item>
      <el-form-item label="0: pending 1: wait to mail 2: mailed 3: finished 4: closed 5: cancelled" prop="status">
        <el-input v-model="dataForm.status"
                  placeholder="0: pending 1: wait to mail 2: mailed 3: finished 4: closed 5: cancelled"></el-input>
      </el-form-item>
      <el-form-item label="" prop="deliveryCompany">
        <el-input v-model="dataForm.deliveryCompany" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="deliverySn">
        <el-input v-model="dataForm.deliverySn" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="autoConfirmDay">
        <el-input v-model="dataForm.autoConfirmDay" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="integration">
        <el-input v-model="dataForm.integration" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="growth">
        <el-input v-model="dataForm.growth" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="invoice type: no invoice 1: e-invoice 2: paper-invoice" prop="billType">
        <el-input v-model="dataForm.billType"
                  placeholder="invoice type: no invoice 1: e-invoice 2: paper-invoice"></el-input>
      </el-form-item>
      <el-form-item label="invoice header" prop="billHeader">
        <el-input v-model="dataForm.billHeader" placeholder="invoice header"></el-input>
      </el-form-item>
      <el-form-item label="invoice content" prop="billContent">
        <el-input v-model="dataForm.billContent" placeholder="invoice content"></el-input>
      </el-form-item>
      <el-form-item label="invoice receiver phone" prop="billReceiverPhone">
        <el-input v-model="dataForm.billReceiverPhone" placeholder="invoice receiver phone"></el-input>
      </el-form-item>
      <el-form-item label="invoice receiver email" prop="billReceiverEmail">
        <el-input v-model="dataForm.billReceiverEmail" placeholder="invoice receiver email"></el-input>
      </el-form-item>
      <el-form-item label="" prop="receiverName">
        <el-input v-model="dataForm.receiverName" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="receiverPhone">
        <el-input v-model="dataForm.receiverPhone" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="receiverPostCode">
        <el-input v-model="dataForm.receiverPostCode" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="receiverProvince">
        <el-input v-model="dataForm.receiverProvince" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="receiverCity">
        <el-input v-model="dataForm.receiverCity" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="receiverRegion">
        <el-input v-model="dataForm.receiverRegion" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="receiverDetailAddress">
        <el-input v-model="dataForm.receiverDetailAddress" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="note">
        <el-input v-model="dataForm.note" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="0: unconfirmed 1: confirmed" prop="confirmStatus">
        <el-input v-model="dataForm.confirmStatus" placeholder="0: unconfirmed 1: confirmed"></el-input>
      </el-form-item>
      <el-form-item label="0: undeleted 1:deleted" prop="deleteStatus">
        <el-input v-model="dataForm.deleteStatus" placeholder="0: undeleted 1:deleted"></el-input>
      </el-form-item>
      <el-form-item label="" prop="useIntegration">
        <el-input v-model="dataForm.useIntegration" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="paymentTime">
        <el-input v-model="dataForm.paymentTime" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="deliveryTime">
        <el-input v-model="dataForm.deliveryTime" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="receiveTime">
        <el-input v-model="dataForm.receiveTime" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="commentTime">
        <el-input v-model="dataForm.commentTime" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="modifyTime">
        <el-input v-model="dataForm.modifyTime" placeholder=""></el-input>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
export default {
  data() {
    return {
      visible: false,
      dataForm: {
        id: 0,
        memberId: '',
        orderSn: '',
        couponId: '',
        createTime: '',
        memberUsername: '',
        totalAmount: '',
        payAmount: '',
        freightAmount: '',
        promotionAmount: '',
        integrationAmount: '',
        couponAmount: '',
        discountAmount: '',
        payType: '',
        sourceType: '',
        status: '',
        deliveryCompany: '',
        deliverySn: '',
        autoConfirmDay: '',
        integration: '',
        growth: '',
        billType: '',
        billHeader: '',
        billContent: '',
        billReceiverPhone: '',
        billReceiverEmail: '',
        receiverName: '',
        receiverPhone: '',
        receiverPostCode: '',
        receiverProvince: '',
        receiverCity: '',
        receiverRegion: '',
        receiverDetailAddress: '',
        note: '',
        confirmStatus: '',
        deleteStatus: '',
        useIntegration: '',
        paymentTime: '',
        deliveryTime: '',
        receiveTime: '',
        commentTime: '',
        modifyTime: ''
      },
      dataRule: {
        memberId: [
          {required: true, message: 'member_id不能为空', trigger: 'blur'}
        ],
        orderSn: [
          {required: true, message: 'order number不能为空', trigger: 'blur'}
        ],
        couponId: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        createTime: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        memberUsername: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        totalAmount: [
          {required: true, message: 'Total payment不能为空', trigger: 'blur'}
        ],
        payAmount: [
          {required: true, message: 'The payment we need to pay不能为空', trigger: 'blur'}
        ],
        freightAmount: [
          {required: true, message: 'postage不能为空', trigger: 'blur'}
        ],
        promotionAmount: [
          {required: true, message: 'promotion不能为空', trigger: 'blur'}
        ],
        integrationAmount: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        couponAmount: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        discountAmount: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        payType: [
          {required: true, message: '1 alipay 2 wechat pay 3 China Unionpay 4 payon delivery不能为空', trigger: 'blur'}
        ],
        sourceType: [
          {required: true, message: '0: PC 1: APP不能为空', trigger: 'blur'}
        ],
        status: [
          {
            required: true,
            message: '0: pending 1: wait to mail 2: mailed 3: finished 4: closed 5: cancelled不能为空',
            trigger: 'blur'
          }
        ],
        deliveryCompany: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        deliverySn: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        autoConfirmDay: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        integration: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        growth: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        billType: [
          {required: true, message: 'invoice type: no invoice 1: e-invoice 2: paper-invoice不能为空', trigger: 'blur'}
        ],
        billHeader: [
          {required: true, message: 'invoice header不能为空', trigger: 'blur'}
        ],
        billContent: [
          {required: true, message: 'invoice content不能为空', trigger: 'blur'}
        ],
        billReceiverPhone: [
          {required: true, message: 'invoice receiver phone不能为空', trigger: 'blur'}
        ],
        billReceiverEmail: [
          {required: true, message: 'invoice receiver email不能为空', trigger: 'blur'}
        ],
        receiverName: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        receiverPhone: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        receiverPostCode: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        receiverProvince: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        receiverCity: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        receiverRegion: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        receiverDetailAddress: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        note: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        confirmStatus: [
          {required: true, message: '0: unconfirmed 1: confirmed不能为空', trigger: 'blur'}
        ],
        deleteStatus: [
          {required: true, message: '0: undeleted 1:deleted不能为空', trigger: 'blur'}
        ],
        useIntegration: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        paymentTime: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        deliveryTime: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        receiveTime: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        commentTime: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        modifyTime: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ]
      }
    }
  },
  methods: {
    init(id) {
      this.dataForm.id = id || 0
      this.visible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].resetFields()
        if (this.dataForm.id) {
          this.$http({
            url: this.$http.adornUrl(`/order/order/info/${this.dataForm.id}`),
            method: 'get',
            params: this.$http.adornParams()
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.dataForm.memberId = data.order.memberId
              this.dataForm.orderSn = data.order.orderSn
              this.dataForm.couponId = data.order.couponId
              this.dataForm.createTime = data.order.createTime
              this.dataForm.memberUsername = data.order.memberUsername
              this.dataForm.totalAmount = data.order.totalAmount
              this.dataForm.payAmount = data.order.payAmount
              this.dataForm.freightAmount = data.order.freightAmount
              this.dataForm.promotionAmount = data.order.promotionAmount
              this.dataForm.integrationAmount = data.order.integrationAmount
              this.dataForm.couponAmount = data.order.couponAmount
              this.dataForm.discountAmount = data.order.discountAmount
              this.dataForm.payType = data.order.payType
              this.dataForm.sourceType = data.order.sourceType
              this.dataForm.status = data.order.status
              this.dataForm.deliveryCompany = data.order.deliveryCompany
              this.dataForm.deliverySn = data.order.deliverySn
              this.dataForm.autoConfirmDay = data.order.autoConfirmDay
              this.dataForm.integration = data.order.integration
              this.dataForm.growth = data.order.growth
              this.dataForm.billType = data.order.billType
              this.dataForm.billHeader = data.order.billHeader
              this.dataForm.billContent = data.order.billContent
              this.dataForm.billReceiverPhone = data.order.billReceiverPhone
              this.dataForm.billReceiverEmail = data.order.billReceiverEmail
              this.dataForm.receiverName = data.order.receiverName
              this.dataForm.receiverPhone = data.order.receiverPhone
              this.dataForm.receiverPostCode = data.order.receiverPostCode
              this.dataForm.receiverProvince = data.order.receiverProvince
              this.dataForm.receiverCity = data.order.receiverCity
              this.dataForm.receiverRegion = data.order.receiverRegion
              this.dataForm.receiverDetailAddress = data.order.receiverDetailAddress
              this.dataForm.note = data.order.note
              this.dataForm.confirmStatus = data.order.confirmStatus
              this.dataForm.deleteStatus = data.order.deleteStatus
              this.dataForm.useIntegration = data.order.useIntegration
              this.dataForm.paymentTime = data.order.paymentTime
              this.dataForm.deliveryTime = data.order.deliveryTime
              this.dataForm.receiveTime = data.order.receiveTime
              this.dataForm.commentTime = data.order.commentTime
              this.dataForm.modifyTime = data.order.modifyTime
            }
          })
        }
      })
    },
    // 表单提交
    dataFormSubmit() {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          this.$http({
            url: this.$http.adornUrl(`/order/order/${!this.dataForm.id ? 'save' : 'update'}`),
            method: 'post',
            data: this.$http.adornData({
              'id': this.dataForm.id || undefined,
              'memberId': this.dataForm.memberId,
              'orderSn': this.dataForm.orderSn,
              'couponId': this.dataForm.couponId,
              'createTime': this.dataForm.createTime,
              'memberUsername': this.dataForm.memberUsername,
              'totalAmount': this.dataForm.totalAmount,
              'payAmount': this.dataForm.payAmount,
              'freightAmount': this.dataForm.freightAmount,
              'promotionAmount': this.dataForm.promotionAmount,
              'integrationAmount': this.dataForm.integrationAmount,
              'couponAmount': this.dataForm.couponAmount,
              'discountAmount': this.dataForm.discountAmount,
              'payType': this.dataForm.payType,
              'sourceType': this.dataForm.sourceType,
              'status': this.dataForm.status,
              'deliveryCompany': this.dataForm.deliveryCompany,
              'deliverySn': this.dataForm.deliverySn,
              'autoConfirmDay': this.dataForm.autoConfirmDay,
              'integration': this.dataForm.integration,
              'growth': this.dataForm.growth,
              'billType': this.dataForm.billType,
              'billHeader': this.dataForm.billHeader,
              'billContent': this.dataForm.billContent,
              'billReceiverPhone': this.dataForm.billReceiverPhone,
              'billReceiverEmail': this.dataForm.billReceiverEmail,
              'receiverName': this.dataForm.receiverName,
              'receiverPhone': this.dataForm.receiverPhone,
              'receiverPostCode': this.dataForm.receiverPostCode,
              'receiverProvince': this.dataForm.receiverProvince,
              'receiverCity': this.dataForm.receiverCity,
              'receiverRegion': this.dataForm.receiverRegion,
              'receiverDetailAddress': this.dataForm.receiverDetailAddress,
              'note': this.dataForm.note,
              'confirmStatus': this.dataForm.confirmStatus,
              'deleteStatus': this.dataForm.deleteStatus,
              'useIntegration': this.dataForm.useIntegration,
              'paymentTime': this.dataForm.paymentTime,
              'deliveryTime': this.dataForm.deliveryTime,
              'receiveTime': this.dataForm.receiveTime,
              'commentTime': this.dataForm.commentTime,
              'modifyTime': this.dataForm.modifyTime
            })
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.visible = false
                  this.$emit('refreshDataList')
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        }
      })
    }
  }
}
</script>
