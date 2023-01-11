<template>
  <el-dialog
      :close-on-click-modal="false"
      :title="!dataForm.id ? '新增' : '修改'"
      :visible.sync="visible">
    <el-form ref="dataForm" :model="dataForm" :rules="dataRule" label-width="80px"
             @keyup.enter.native="dataFormSubmit()">
      <el-form-item label="Buyer id" prop="assigneeId">
        <el-input v-model="dataForm.assigneeId" placeholder="Buyer id"></el-input>
      </el-form-item>
      <el-form-item label="Buyer name" prop="assigneeName">
        <el-input v-model="dataForm.assigneeName" placeholder="Buyer name"></el-input>
      </el-form-item>
      <el-form-item label="" prop="phone">
        <el-input v-model="dataForm.phone" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="priority">
        <el-input v-model="dataForm.priority" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="status">
        <el-input v-model="dataForm.status" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="warehouse id" prop="wareId">
        <el-input v-model="dataForm.wareId" placeholder="warehouse id"></el-input>
      </el-form-item>
      <el-form-item label="amount" prop="amount">
        <el-input v-model="dataForm.amount" placeholder="amount"></el-input>
      </el-form-item>
      <el-form-item label="" prop="createTime">
        <el-input v-model="dataForm.createTime" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="updateTime">
        <el-input v-model="dataForm.updateTime" placeholder=""></el-input>
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
        assigneeId: '',
        assigneeName: '',
        phone: '',
        priority: '',
        status: '',
        wareId: '',
        amount: '',
        createTime: '',
        updateTime: ''
      },
      dataRule: {
        assigneeId: [
          {required: true, message: 'Buyer id不能为空', trigger: 'blur'}
        ],
        assigneeName: [
          {required: true, message: 'Buyer name不能为空', trigger: 'blur'}
        ],
        phone: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        priority: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        status: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        wareId: [
          {required: true, message: 'warehouse id不能为空', trigger: 'blur'}
        ],
        amount: [
          {required: true, message: 'amount不能为空', trigger: 'blur'}
        ],
        createTime: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        updateTime: [
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
            url: this.$http.adornUrl(`/ware/purchase/info/${this.dataForm.id}`),
            method: 'get',
            params: this.$http.adornParams()
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.dataForm.assigneeId = data.purchase.assigneeId
              this.dataForm.assigneeName = data.purchase.assigneeName
              this.dataForm.phone = data.purchase.phone
              this.dataForm.priority = data.purchase.priority
              this.dataForm.status = data.purchase.status
              this.dataForm.wareId = data.purchase.wareId
              this.dataForm.amount = data.purchase.amount
              this.dataForm.createTime = data.purchase.createTime
              this.dataForm.updateTime = data.purchase.updateTime
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
            url: this.$http.adornUrl(`/ware/purchase/${!this.dataForm.id ? 'save' : 'update'}`),
            method: 'post',
            data: this.$http.adornData({
              'id': this.dataForm.id || undefined,
              'assigneeId': this.dataForm.assigneeId,
              'assigneeName': this.dataForm.assigneeName,
              'phone': this.dataForm.phone,
              'priority': this.dataForm.priority,
              'status': this.dataForm.status,
              'wareId': this.dataForm.wareId,
              'amount': this.dataForm.amount,
              'createTime': this.dataForm.createTime,
              'updateTime': this.dataForm.updateTime
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
