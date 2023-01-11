<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" clearable placeholder="参数名"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('order:order:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('order:order:delete')" :disabled="dataListSelections.length <= 0" type="danger"
                   @click="deleteHandle()">批量删除
        </el-button>
      </el-form-item>
    </el-form>
    <el-table
        v-loading="dataListLoading"
        :data="dataList"
        border
        style="width: 100%;"
        @selection-change="selectionChangeHandle">
      <el-table-column
          align="center"
          header-align="center"
          type="selection"
          width="50">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="id"
          prop="id">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="member_id"
          prop="memberId">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="order number"
          prop="orderSn">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="couponId">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="createTime">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="memberUsername">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="Total payment"
          prop="totalAmount">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="The payment we need to pay"
          prop="payAmount">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="postage"
          prop="freightAmount">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="promotion"
          prop="promotionAmount">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="integrationAmount">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="couponAmount">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="discountAmount">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="1 alipay 2 wechat pay 3 China Unionpay 4 payon delivery"
          prop="payType">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="0: PC 1: APP"
          prop="sourceType">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="0: pending 1: wait to mail 2: mailed 3: finished 4: closed 5: cancelled"
          prop="status">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="deliveryCompany">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="deliverySn">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="autoConfirmDay">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="integration">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="growth">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="invoice type: no invoice 1: e-invoice 2: paper-invoice"
          prop="billType">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="invoice header"
          prop="billHeader">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="invoice content"
          prop="billContent">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="invoice receiver phone"
          prop="billReceiverPhone">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="invoice receiver email"
          prop="billReceiverEmail">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="receiverName">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="receiverPhone">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="receiverPostCode">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="receiverProvince">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="receiverCity">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="receiverRegion">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="receiverDetailAddress">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="note">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="0: unconfirmed 1: confirmed"
          prop="confirmStatus">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="0: undeleted 1:deleted"
          prop="deleteStatus">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="useIntegration">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="paymentTime">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="deliveryTime">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="receiveTime">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="commentTime">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="modifyTime">
      </el-table-column>
      <el-table-column
          align="center"
          fixed="right"
          header-align="center"
          label="操作"
          width="150">
        <template slot-scope="scope">
          <el-button size="small" type="text" @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
          <el-button size="small" type="text" @click="deleteHandle(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        :current-page="pageIndex"
        :page-size="pageSize"
        :page-sizes="[10, 20, 50, 100]"
        :total="totalPage"
        layout="total, sizes, prev, pager, next, jumper"
        @size-change="sizeChangeHandle"
        @current-change="currentChangeHandle">
    </el-pagination>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
  </div>
</template>

<script>
import AddOrUpdate from './order-add-or-update'

export default {
  data() {
    return {
      dataForm: {
        key: ''
      },
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      addOrUpdateVisible: false
    }
  },
  components: {
    AddOrUpdate
  },
  activated() {
    this.getDataList()
  },
  methods: {
    // 获取数据列表
    getDataList() {
      this.dataListLoading = true
      this.$http({
        url: this.$http.adornUrl('/order/order/list'),
        method: 'get',
        params: this.$http.adornParams({
          'page': this.pageIndex,
          'limit': this.pageSize,
          'key': this.dataForm.key
        })
      }).then(({data}) => {
        if (data && data.code === 0) {
          this.dataList = data.page.list
          this.totalPage = data.page.totalCount
        } else {
          this.dataList = []
          this.totalPage = 0
        }
        this.dataListLoading = false
      })
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val
      this.pageIndex = 1
      this.getDataList()
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val
      this.getDataList()
    },
    // 多选
    selectionChangeHandle(val) {
      this.dataListSelections = val
    },
    // 新增 / 修改
    addOrUpdateHandle(id) {
      this.addOrUpdateVisible = true
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id)
      })
    },
    // 删除
    deleteHandle(id) {
      var ids = id ? [id] : this.dataListSelections.map(item => {
        return item.id
      })
      this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$http({
          url: this.$http.adornUrl('/order/order/delete'),
          method: 'post',
          data: this.$http.adornData(ids, false)
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.$message({
              message: '操作成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                this.getDataList()
              }
            })
          } else {
            this.$message.error(data.msg)
          }
        })
      })
    }
  }
}
</script>
