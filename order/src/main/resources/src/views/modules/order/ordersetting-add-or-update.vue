<template>
  <el-dialog
      :close-on-click-modal="false"
      :title="!dataForm.id ? '新增' : '修改'"
      :visible.sync="visible">
    <el-form ref="dataForm" :model="dataForm" :rules="dataRule" label-width="80px"
             @keyup.enter.native="dataFormSubmit()">
      <el-form-item label="" prop="flashOrderOvertime">
        <el-input v-model="dataForm.flashOrderOvertime" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="normalOrderOvertime">
        <el-input v-model="dataForm.normalOrderOvertime" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="confirmOvertime">
        <el-input v-model="dataForm.confirmOvertime" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="Return with in specified days" prop="finishOvertime">
        <el-input v-model="dataForm.finishOvertime" placeholder="Return with in specified days"></el-input>
      </el-form-item>
      <el-form-item label="" prop="commentOvertime">
        <el-input v-model="dataForm.commentOvertime" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="memberLevel">
        <el-input v-model="dataForm.memberLevel" placeholder=""></el-input>
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
        flashOrderOvertime: '',
        normalOrderOvertime: '',
        confirmOvertime: '',
        finishOvertime: '',
        commentOvertime: '',
        memberLevel: ''
      },
      dataRule: {
        flashOrderOvertime: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        normalOrderOvertime: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        confirmOvertime: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        finishOvertime: [
          {required: true, message: 'Return with in specified days不能为空', trigger: 'blur'}
        ],
        commentOvertime: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        memberLevel: [
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
            url: this.$http.adornUrl(`/order/ordersetting/info/${this.dataForm.id}`),
            method: 'get',
            params: this.$http.adornParams()
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.dataForm.flashOrderOvertime = data.orderSetting.flashOrderOvertime
              this.dataForm.normalOrderOvertime = data.orderSetting.normalOrderOvertime
              this.dataForm.confirmOvertime = data.orderSetting.confirmOvertime
              this.dataForm.finishOvertime = data.orderSetting.finishOvertime
              this.dataForm.commentOvertime = data.orderSetting.commentOvertime
              this.dataForm.memberLevel = data.orderSetting.memberLevel
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
            url: this.$http.adornUrl(`/order/ordersetting/${!this.dataForm.id ? 'save' : 'update'}`),
            method: 'post',
            data: this.$http.adornData({
              'id': this.dataForm.id || undefined,
              'flashOrderOvertime': this.dataForm.flashOrderOvertime,
              'normalOrderOvertime': this.dataForm.normalOrderOvertime,
              'confirmOvertime': this.dataForm.confirmOvertime,
              'finishOvertime': this.dataForm.finishOvertime,
              'commentOvertime': this.dataForm.commentOvertime,
              'memberLevel': this.dataForm.memberLevel
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
