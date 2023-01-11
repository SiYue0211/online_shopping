<template>
  <el-dialog
      :close-on-click-modal="false"
      :title="!dataForm.id ? '新增' : '修改'"
      :visible.sync="visible">
    <el-form ref="dataForm" :model="dataForm" :rules="dataRule" label-width="80px"
             @keyup.enter.native="dataFormSubmit()">
      <el-form-item label="" prop="spuId">
        <el-input v-model="dataForm.spuId" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="growth points" prop="growBounds">
        <el-input v-model="dataForm.growBounds" placeholder="growth points"></el-input>
      </el-form-item>
      <el-form-item label="shopping points" prop="buyBounds">
        <el-input v-model="dataForm.buyBounds" placeholder="shopping points"></el-input>
      </el-form-item>
      <el-form-item
          label="Four-digit status code, from right to left; 0: No discount, whether to give growth points; 1: No discount, whether to give shopping points;2: Discount, whether to give growth points;3: Discount, whether to give shopping points"
          prop="work">
        <el-input v-model="dataForm.work"
                  placeholder="Four-digit status code, from right to left; 0: No discount, whether to give growth points; 1: No discount, whether to give shopping points;2: Discount, whether to give growth points;3: Discount, whether to give shopping points"></el-input>
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
        spuId: '',
        growBounds: '',
        buyBounds: '',
        work: ''
      },
      dataRule: {
        spuId: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        growBounds: [
          {required: true, message: 'growth points不能为空', trigger: 'blur'}
        ],
        buyBounds: [
          {required: true, message: 'shopping points不能为空', trigger: 'blur'}
        ],
        work: [
          {
            required: true,
            message: 'Four-digit status code, from right to left; 0: No discount, whether to give growth points; 1: No discount, whether to give shopping points;2: Discount, whether to give growth points;3: Discount, whether to give shopping points不能为空',
            trigger: 'blur'
          }
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
            url: this.$http.adornUrl(`/coupon/spubounds/info/${this.dataForm.id}`),
            method: 'get',
            params: this.$http.adornParams()
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.dataForm.spuId = data.spuBounds.spuId
              this.dataForm.growBounds = data.spuBounds.growBounds
              this.dataForm.buyBounds = data.spuBounds.buyBounds
              this.dataForm.work = data.spuBounds.work
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
            url: this.$http.adornUrl(`/coupon/spubounds/${!this.dataForm.id ? 'save' : 'update'}`),
            method: 'post',
            data: this.$http.adornData({
              'id': this.dataForm.id || undefined,
              'spuId': this.dataForm.spuId,
              'growBounds': this.dataForm.growBounds,
              'buyBounds': this.dataForm.buyBounds,
              'work': this.dataForm.work
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
