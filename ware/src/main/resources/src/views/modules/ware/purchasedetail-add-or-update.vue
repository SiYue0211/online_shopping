<template>
  <el-dialog
      :close-on-click-modal="false"
      :title="!dataForm.id ? '新增' : '修改'"
      :visible.sync="visible">
    <el-form ref="dataForm" :model="dataForm" :rules="dataRule" label-width="80px"
             @keyup.enter.native="dataFormSubmit()">
      <el-form-item label="" prop="purchaseId">
        <el-input v-model="dataForm.purchaseId" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="item id" prop="skuId">
        <el-input v-model="dataForm.skuId" placeholder="item id"></el-input>
      </el-form-item>
      <el-form-item label="item number" prop="skuNum">
        <el-input v-model="dataForm.skuNum" placeholder="item number"></el-input>
      </el-form-item>
      <el-form-item label="item amount" prop="skuPrice">
        <el-input v-model="dataForm.skuPrice" placeholder="item amount"></el-input>
      </el-form-item>
      <el-form-item label="warehouse id" prop="wareId">
        <el-input v-model="dataForm.wareId" placeholder="warehouse id"></el-input>
      </el-form-item>
      <el-form-item label="0-created; 1-dispensed; 2-doing; 3-done; 4-failure" prop="status">
        <el-input v-model="dataForm.status" placeholder="0-created; 1-dispensed; 2-doing; 3-done; 4-failure"></el-input>
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
        purchaseId: '',
        skuId: '',
        skuNum: '',
        skuPrice: '',
        wareId: '',
        status: ''
      },
      dataRule: {
        purchaseId: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        skuId: [
          {required: true, message: 'item id不能为空', trigger: 'blur'}
        ],
        skuNum: [
          {required: true, message: 'item number不能为空', trigger: 'blur'}
        ],
        skuPrice: [
          {required: true, message: 'item amount不能为空', trigger: 'blur'}
        ],
        wareId: [
          {required: true, message: 'warehouse id不能为空', trigger: 'blur'}
        ],
        status: [
          {required: true, message: '0-created; 1-dispensed; 2-doing; 3-done; 4-failure不能为空', trigger: 'blur'}
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
            url: this.$http.adornUrl(`/ware/purchasedetail/info/${this.dataForm.id}`),
            method: 'get',
            params: this.$http.adornParams()
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.dataForm.purchaseId = data.purchaseDetail.purchaseId
              this.dataForm.skuId = data.purchaseDetail.skuId
              this.dataForm.skuNum = data.purchaseDetail.skuNum
              this.dataForm.skuPrice = data.purchaseDetail.skuPrice
              this.dataForm.wareId = data.purchaseDetail.wareId
              this.dataForm.status = data.purchaseDetail.status
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
            url: this.$http.adornUrl(`/ware/purchasedetail/${!this.dataForm.id ? 'save' : 'update'}`),
            method: 'post',
            data: this.$http.adornData({
              'id': this.dataForm.id || undefined,
              'purchaseId': this.dataForm.purchaseId,
              'skuId': this.dataForm.skuId,
              'skuNum': this.dataForm.skuNum,
              'skuPrice': this.dataForm.skuPrice,
              'wareId': this.dataForm.wareId,
              'status': this.dataForm.status
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
