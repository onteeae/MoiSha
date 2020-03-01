<template>
  <div>
    <div class="card">
      <div class="card-header" @click="getModal">
        {{item.title}}<br>{{item.authorId}}
      </div>
      <div class="card-body">
        <p class="card-text">
          {{item.contents}}
        </p>
      </div>
    </div>

    <div id="myModal" class="modal" v-show="showModal">
      <div class="modal-content">
        <span class="close" @click="closeModal">close</span>
        <ArticleDetail v-bind:item="item"></ArticleDetail>
      </div>
    </div>
  </div>

</template>

<script>
import ArticleDetail from './ArticleDetail'
export default {
  name: 'Article',
  components: {ArticleDetail},
  props: {
    item: {
      type: Object,
      default: null
    }
  },
  data () {
    return {
      showModal: false
    }
  },
  methods: {
    getModal: function () {
      this.showModal = true
    },
    closeModal: function () {
      this.showModal = false
    }
  }
}
</script>

<style scoped>
  .modal{
    display: block;
    position:fixed;
    z-index: 1;
    left:0;
    top:0;
    width:100%;
    height:100%;
    overflow:auto;
    background-color: rgba(0,0,0,0.4);
  }
  .modal-content{
    margin:15% auto;
    padding:20px;
    width:80%;
  }
  .close{
    text-align: right;
    color:#777;
    font-weight: bold;
  }
  .close:hover,
  .close:focus{
    color:black;
    text-decoration: none;
    cursor:pointer;
  }

  .card-header{
    cursor: pointer;
  }
</style>
