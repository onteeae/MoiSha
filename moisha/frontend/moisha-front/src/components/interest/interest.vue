<template>
  <div>
    <div class="container col-4 control-pad">
      <div class="row">
        <button class="btn btn-success">새 관심사 만들기</button>
      </div>
      <br>
    </div>
    <div class="row">
      <div class="interest-list col-4">
        <h6 class="header feed-header">모든 관심사!</h6>
          <InterestList></InterestList>
      </div>
      <div class="interest-recommend-list col-3">
        <h6 class="header interest-header">이런 관심사는 어떠세요?</h6>
        <InterestList></InterestList>
      </div>
    </div>
  </div>
</template>

<script>
import InterestList from '../Shared/InterestList'
export default {
  name: 'interest',
  components: {InterestList}
}
</script>

<style scoped>

</style>
