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
      <el-form-item label="" prop="spuId">
        <el-input v-model="dataForm.spuId" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="spuName">
        <el-input v-model="dataForm.spuName" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="spuImg">
        <el-input v-model="dataForm.spuImg" placeholder=""></el-input>
      </el-form-item>
      <el-form-item label="" prop="createTime">
        <el-input v-model="dataForm.createTime" placeholder=""></el-input>
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
        spuId: '',
        spuName: '',
        spuImg: '',
        createTime: ''
      },
      dataRule: {
        memberId: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        spuId: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        spuName: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        spuImg: [
          {required: true, message: '不能为空', trigger: 'blur'}
        ],
        createTime: [
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
            url: this.$http.adornUrl(`/member/membercollectspu/info/${this.dataForm.id}`),
            method: 'get',
            params: this.$http.adornParams()
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.dataForm.memberId = data.memberCollectSpu.memberId
              this.dataForm.spuId = data.memberCollectSpu.spuId
              this.dataForm.spuName = data.memberCollectSpu.spuName
              this.dataForm.spuImg = data.memberCollectSpu.spuImg
              this.dataForm.createTime = data.memberCollectSpu.createTime
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
            url: this.$http.adornUrl(`/member/membercollectspu/${!this.dataForm.id ? 'save' : 'update'}`),
            method: 'post',
            data: this.$http.adornData({
              'id': this.dataForm.id || undefined,
              'memberId': this.dataForm.memberId,
              'spuId': this.dataForm.spuId,
              'spuName': this.dataForm.spuName,
              'spuImg': this.dataForm.spuImg,
              'createTime': this.dataForm.createTime
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
