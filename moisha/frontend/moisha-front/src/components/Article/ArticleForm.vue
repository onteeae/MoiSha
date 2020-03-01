<template>
  <div>
    <form class="form-interest" v-on:submit.prevent="confirmArticle()">
      <b-alert v-if="errorMessage" dismissible>{{errorMessage}}</b-alert>
      <div class="form-control">
        <span class="badge badgefirst" style="background-color: lightcoral" v-for="interest in interests" :key="interest.interestNo">
          {{interest.name}}
          <span class="removeSelected" @click="removeInterest(interest)">&nbsp;x</span>
        </span>
      </div>
        <input type="select"
                 class="form-control"
                 id="inputInterest"
                 placeholder="어떤 관심사에 쓸까요?" />
      <div class="alert alert-danger" v-if="selectedInterests.length ==0">
        글이 작성될 관심사를 입력해주세요
      </div>
      <div class="alert alert-danger">
        구독한 관심사에만 작성할 수 있습니다.
      </div>
      <br>
      <div class="form-contorl">
      <span class="badge badgefirst">
        <span class="removeSelected">&nbsp;x</span>
      </span>
        <input type="select"
               class="form-control"
               id="inputArticleTag"
               placeholder="태그? ex) 공지, 잡담, QNA ..." />
      </div>
      <div class="alert alert-danger">
        존재하지 않는 태그입니다
      </div>
      <br>
      <input type="text"
                class="form-control"
                id="inputTitle"
                placeholder="글 제목"
                v-on:input="title_typing"/>
      <div class="alert alert-danger" v-if="titleLen==0">
        글 제목을 입력해주세요
      </div>
      <div class="alert alert-danger">
        제목은 80자 이내여야 합니다. 현재: {{titleLen}} 자
      </div>
      <br>
      <textarea type="text"
                class="form-control"
                id="inputContent"
                placeholder="글 내용"
                v-on:input="content_typing">
      </textarea>
      <div class="alert alert-danger" v-if="contentLen==0">
        글 내을 입력해주세요
      </div>
      <div class="alert alert-danger">
        내용은 1400자 이내여야 합니다. 현재: {{contentLen}}자
      </div>
      <button type="submit" class="btn btn-lg btn-primary btn-block">
        <b-container>저장</b-container>
      </button>
    </form>
    <span class="badge" style="background-color: lightcoral">
    </span>
    <span class="badge">
    </span>
  </div>
</template>

<script>

export default {
  name: 'ArticleForm',
  data () {
    return {
      errorMessage: false,
      selectedInterests: [],
      titleLen: 0,
      contentLen: 0,
      interests: []
    }
  },
  created () {
    this.$http.get('/api/interests/user/jay')
      .then(response => {
        this.interests = response.data.map(r => r)
      })
      .catch(error => {
        console.log(error)
      })
  },
  methods: {
    confirmArticle () {
      const payload = {
        author: this.$store.state.auth.user.username
      }
      this.$http.post('/api/articles/interest/1', payload)
        .then(response => {
          console.log(response)
        }, error => {
          console.log(error)
        })
    },
    removeInterest (interest) {
      this.selectedInterests = this.selectedInterests.filter((t) => t.id !== interest.InterestNo)
    },
    title_typing (e) {
      var val = e.target.value
      this.titleLen = val.length
    },
    content_typing (e) {
      var val = e.target.value
      this.contentLen = val.length
    }
  }
}
</script>

<style scoped>
  .form-interest{
    padding-top: 20px;
  }
  .badge{
    color: #ffffff;
    width: 100%;
    height: 100%;
    font-size: 16px;
  }
  .badgefirst{
    color: #ffffff;
    width: 30%;
    height: 100%;
    margin-bottom: 2px;
    margin-top: 2px;
    font-size: 16px;
  }
  #inputTitle{
    height: 80px;
  }
  #inputContent{
    height: 200px;
  }
</style>
