<template>
  <el-dialog
      :close-on-click-modal="false"
      :title="!dataForm.id ? '新增' : '修改'"
      :visible.sync="visible">
    <el-form ref="dataForm" :model="dataForm" :rules="dataRule" label-width="80px"
             @keyup.enter.native="dataFormSubmit()">
      <el-form-item label="" prop="memberId">
        <el-input v-model="dataForm.memberId" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="Current spend" prop="consumeAmount">
        <el-input v-model="dataForm.consumeAmount" placeholder="Current spend"></el-input>
      </el-form-item>
      <el-form-item label="Current coupon spend" prop="couponAmount">
        <el-input v-model="dataForm.couponAmount" placeholder="Current coupon spend"></el-input>
      </el-form-item>
      <el-form-item label="" prop="orderCount">
        <el-input v-model="dataForm.orderCount" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="couponCount">
        <el-input v-model="dataForm.couponCount" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="commentCount">
        <el-input v-model="dataForm.commentCount" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="returnOrderCount">
        <el-input v-model="dataForm.returnOrderCount" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="loginCount">
        <el-input v-model="dataForm.loginCount" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="Follow number" prop="attendCount">
        <el-input v-model="dataForm.attendCount" placeholder="Follow number"></el-input>
      </el-form-item>
      <el-form-item label="Fans number" prop="fansCount">
        <el-input v-model="dataForm.fansCount" placeholder="Fans number"></el-input>
      </el-form-item>
      <el-form-item label="" prop="collectProductCount">
        <el-input v-model="dataForm.collectProductCount" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="collectSubjectCount">
        <el-input v-model="dataForm.collectSubjectCount" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="collectCommentCount">
        <el-input v-model="dataForm.collectCommentCount" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="inviteFriendCount">
        <el-input v-model="dataForm.inviteFriendCount" placeholder=""></el-input>
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
        consumeAmount: '',
        couponAmount: '',
        orderCount: '',
        couponCount: '',
        commentCount: '',
        returnOrderCount: '',
        loginCount: '',
        attendCount: '',
        fansCount: '',
        collectProductCount: '',
        collectSubjectCount: '',
        collectCommentCount: '',
        inviteFriendCount: ''
      },
      dataRule: {
        memberId: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        consumeAmount: [
          {required: true, message: 'Current spend不能为空', trigger: 'blur'}
        ],
        couponAmount: [
          {required: true, message: 'Current coupon spend不能为空', trigger: 'blur'}
        ],
        orderCount: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        couponCount: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        commentCount: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        returnOrderCount: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        loginCount: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        attendCount: [
          {required: true, message: 'Follow number不能为空', trigger: 'blur'}
        ],
        fansCount: [
          {required: true, message: 'Fans number不能为空', trigger: 'blur'}
        ],
        collectProductCount: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        collectSubjectCount: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        collectCommentCount: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        inviteFriendCount: [
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
            url: this.$http.adornUrl(`/member/memberstatisticsinfo/info/${this.dataForm.id}`),
            method: 'get',
            params: this.$http.adornParams()
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.dataForm.memberId = data.memberStatisticsInfo.memberId
              this.dataForm.consumeAmount = data.memberStatisticsInfo.consumeAmount
              this.dataForm.couponAmount = data.memberStatisticsInfo.couponAmount
              this.dataForm.orderCount = data.memberStatisticsInfo.orderCount
              this.dataForm.couponCount = data.memberStatisticsInfo.couponCount
              this.dataForm.commentCount = data.memberStatisticsInfo.commentCount
              this.dataForm.returnOrderCount = data.memberStatisticsInfo.returnOrderCount
              this.dataForm.loginCount = data.memberStatisticsInfo.loginCount
              this.dataForm.attendCount = data.memberStatisticsInfo.attendCount
              this.dataForm.fansCount = data.memberStatisticsInfo.fansCount
              this.dataForm.collectProductCount = data.memberStatisticsInfo.collectProductCount
              this.dataForm.collectSubjectCount = data.memberStatisticsInfo.collectSubjectCount
              this.dataForm.collectCommentCount = data.memberStatisticsInfo.collectCommentCount
              this.dataForm.inviteFriendCount = data.memberStatisticsInfo.inviteFriendCount
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
            url: this.$http.adornUrl(`/member/memberstatisticsinfo/${!this.dataForm.id ? 'save' : 'update'}`),
            method: 'post',
            data: this.$http.adornData({
              'id': this.dataForm.id || undefined,
              'memberId': this.dataForm.memberId,
              'consumeAmount': this.dataForm.consumeAmount,
              'couponAmount': this.dataForm.couponAmount,
              'orderCount': this.dataForm.orderCount,
              'couponCount': this.dataForm.couponCount,
              'commentCount': this.dataForm.commentCount,
              'returnOrderCount': this.dataForm.returnOrderCount,
              'loginCount': this.dataForm.loginCount,
              'attendCount': this.dataForm.attendCount,
              'fansCount': this.dataForm.fansCount,
              'collectProductCount': this.dataForm.collectProductCount,
              'collectSubjectCount': this.dataForm.collectSubjectCount,
              'collectCommentCount': this.dataForm.collectCommentCount,
              'inviteFriendCount': this.dataForm.inviteFriendCount
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
