<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" clearable placeholder="参数名"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('coupon:coupon:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('coupon:coupon:delete')" :disabled="dataListSelections.length <= 0" type="danger"
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
          label="0: For all kind of user; 1: For members; 2: For shopping users; 3. For new register users"
          prop="couponType">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="couponImg">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="couponName">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="Coupon number"
          prop="num">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="Coupon Amount"
          prop="amount">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="The limit coupon number for each people"
          prop="perLimit">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="The min threshold to use coupon"
          prop="minPoint">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="startTime">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="endTime">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="0->All 1->Some specified types 2->Some specified items]"
          prop="useType">
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
          label=""
          prop="publishCount">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label=""
          prop="useCount">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="The count of coupon that has been got"
          prop="receiveCount">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="The start time to pick up the coupons"
          prop="enableStartTime">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="Then end time to pick up the coupons"
          prop="enableEndTime">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="coupon code"
          prop="code">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="The member level that can pick up the coupons 0->Any one, Others->specified level"
          prop="memberLevel">
      </el-table-column>
      <el-table-column
          align="center"
          header-align="center"
          label="0: false, 1: true"
          prop="publish">
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
import AddOrUpdate from './coupon-add-or-update'

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
        url: this.$http.adornUrl('/coupon/coupon/list'),
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
          url: this.$http.adornUrl('/coupon/coupon/delete'),
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
