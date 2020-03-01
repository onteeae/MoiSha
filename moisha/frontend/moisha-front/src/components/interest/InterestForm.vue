<template>
  <div>
    <div class="container col-4 control-pad">
      <router-link tag="button" class="btn btn-success" to="Interest/Create">새 글 쓰기</router-link>
      <br>

    </div>
    <div class="row">
      <div class="article-list col-4">
        <h6 class="feed-header">새로운 피드</h6>
        <app-feed-list
          [articles]="articles"
          (scroll)="fetchMoreFeed()"
        ></app-feed-list>
      </div>
      <div class="interest-list col-3">
        <h6 class="interest-header">{{interest?.name}} 관련 관심사</h6>
        <app-interest-list *ngIf = "shouldLoad | async"
                           [interests]="interests">
        </app-interest-list>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'InterestForm'
}
</script>

<style scoped>
  .article-list{
    margin-left: 20%;
    border: 2px solid #333333;
    border-radius: 20px;
  }
  .interest-list{
    margin-left: 75%;
    border: 2px solid #333333;
    border-radius: 20px;
    overflow-y: scroll;
    max-height: 600px;
    position: fixed;
  }
  .badge-filter{
    cursor: pointer;
    color: #ffffff;
    font-size: 18px;
    margin: auto;
    padding: 4px 5px;
    border-radius: 3px;
  }
  .interest-list::-webkit-scrollbar{
    display: none;
  }
  .feed-header{
    font-size: 27px;
    text-align: center;
  }
  .interest-header{
    font-size: 27px;
    text-align: center;
    border-bottom: 2px solid black;
  }
  .suggest{
    margin-top:10%;
  }
  .control-pad{
    border: 2px solid #333333;
    padding-top: 2px;
    padding-bottom: 2px;
    margin-top: 10px;
    margin-bottom: 10px;
  }

</style>
