<template>
<div>
  <div class="view">
    <InterestList></InterestList>
  </div>
    <div id="noResults">
      <h1>가입중인 관심사가 없습니다!</h1>
    </div>
</div>
</template>

<script>
import InterestList from '../Shared/InterestList'
export default {
  name: 'ProfileInterest',
  components: {InterestList}
}
</script>

<style scoped>
  #noResults{
    margin: auto;
    padding-top: 100px;
  }

</style>
