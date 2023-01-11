<template>
  <el-dialog
      :close-on-click-modal="false"
      :title="!dataForm.id ? '新增' : '修改'"
      :visible.sync="visible">
    <el-form ref="dataForm" :model="dataForm" :rules="dataRule" label-width="80px"
             @keyup.enter.native="dataFormSubmit()">
      <el-form-item label="" prop="name">
        <el-input v-model="dataForm.name" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="growthPoint">
        <el-input v-model="dataForm.growthPoint" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="defaultStatus">
        <el-input v-model="dataForm.defaultStatus" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="The standard of free postage" prop="freeFreightPoint">
        <el-input v-model="dataForm.freeFreightPoint" placeholder="The standard of free postage"></el-input>
      </el-form-item>
      <el-form-item label="growth points from comment item" prop="commentGrowthPoint">
        <el-input v-model="dataForm.commentGrowthPoint" placeholder="growth points from comment item"></el-input>
      </el-form-item>
      <el-form-item label="Free postage right" prop="priviledgeFreeFreight">
        <el-input v-model="dataForm.priviledgeFreeFreight" placeholder="Free postage right"></el-input>
      </el-form-item>
      <el-form-item label="Member price right" prop="priviledgeMemberPrice">
        <el-input v-model="dataForm.priviledgeMemberPrice" placeholder="Member price right"></el-input>
      </el-form-item>
      <el-form-item label="Birthday price right" prop="priviledgeBirthday">
        <el-input v-model="dataForm.priviledgeBirthday" placeholder="Birthday price right"></el-input>
      </el-form-item>
      <el-form-item label="" prop="note">
        <el-input v-model="dataForm.note" placeholder=""></el-input>
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
        name: '',
        growthPoint: '',
        defaultStatus: '',
        freeFreightPoint: '',
        commentGrowthPoint: '',
        priviledgeFreeFreight: '',
        priviledgeMemberPrice: '',
        priviledgeBirthday: '',
        note: ''
      },
      dataRule: {
        name: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        growthPoint: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        defaultStatus: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        freeFreightPoint: [
          {required: true, message: 'The standard of free postage不能为空', trigger: 'blur'}
        ],
        commentGrowthPoint: [
          {required: true, message: 'growth points from comment item不能为空', trigger: 'blur'}
        ],
        priviledgeFreeFreight: [
          {required: true, message: 'Free postage right不能为空', trigger: 'blur'}
        ],
        priviledgeMemberPrice: [
          {required: true, message: 'Member price right不能为空', trigger: 'blur'}
        ],
        priviledgeBirthday: [
          {required: true, message: 'Birthday price right不能为空', trigger: 'blur'}
        ],
        note: [
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
            url: this.$http.adornUrl(`/member/memberlevel/info/${this.dataForm.id}`),
            method: 'get',
            params: this.$http.adornParams()
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.dataForm.name = data.memberLevel.name
              this.dataForm.growthPoint = data.memberLevel.growthPoint
              this.dataForm.defaultStatus = data.memberLevel.defaultStatus
              this.dataForm.freeFreightPoint = data.memberLevel.freeFreightPoint
              this.dataForm.commentGrowthPoint = data.memberLevel.commentGrowthPoint
              this.dataForm.priviledgeFreeFreight = data.memberLevel.priviledgeFreeFreight
              this.dataForm.priviledgeMemberPrice = data.memberLevel.priviledgeMemberPrice
              this.dataForm.priviledgeBirthday = data.memberLevel.priviledgeBirthday
              this.dataForm.note = data.memberLevel.note
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
            url: this.$http.adornUrl(`/member/memberlevel/${!this.dataForm.id ? 'save' : 'update'}`),
            method: 'post',
            data: this.$http.adornData({
              'id': this.dataForm.id || undefined,
              'name': this.dataForm.name,
              'growthPoint': this.dataForm.growthPoint,
              'defaultStatus': this.dataForm.defaultStatus,
              'freeFreightPoint': this.dataForm.freeFreightPoint,
              'commentGrowthPoint': this.dataForm.commentGrowthPoint,
              'priviledgeFreeFreight': this.dataForm.priviledgeFreeFreight,
              'priviledgeMemberPrice': this.dataForm.priviledgeMemberPrice,
              'priviledgeBirthday': this.dataForm.priviledgeBirthday,
              'note': this.dataForm.note
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
