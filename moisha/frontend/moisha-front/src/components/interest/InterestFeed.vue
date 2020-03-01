<template>
    <div>
      <div class="container col-4 control-pad">
        <button class="btn btn-success">새 글 쓰기</button>
        <br>
        <span class="badge badge-filter">{{tag.name}}</span>
      </div>
      <div class="row">
        <div class="article-list col-4">
          <h6 class="feed-header">새로운 피드</h6>

        </div>
        <div class="interest-list col-3">
          <h6 class="interest-header">{{interest?.name}} 관련 관심사</h6>
        </div>
      </div>

    </div>
</template>

<script>
export default {
  name: 'InterestFeed'
}
</script>

<style scoped>

</style>
