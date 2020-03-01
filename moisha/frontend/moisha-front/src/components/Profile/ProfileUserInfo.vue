<template>
  <div class="container">
    <h5>회원정보</h5>
    <form class="form-user-info" v-on:submit.prevent="submitInfo()">
      <div class="form-group row">
        <label for="inputEmail" class="col-sm-2 col-form-label">이메일(id)</label>
        <div class="col-sm-5">
          <input type="email" class="form-control" id="inputEmail">
        </div>
        <button type="checkDuplicate" class="btn btn-danger" @click="checkEmail()">중복 확인</button>
        <span class="alert alert-danger">
        이메일 형식에 맞춰주세요
      </span>
        <span class="alert alert-danger">
        이메일을 입력해주세요
      </span>
        <span class="alert alert-danger">
        중복 확인이 필요합니다.
      </span>
        <span class="alert alert-danger">
        이미 이메일이 존재합니다.
      </span>
      </div>
      <div class="form-group row">
        <label for="inputPassword" class="col-sm-2 col-form-label">비밀번호</label>
        <div class="col-sm-5">
          <input type="password" class="form-control" id="inputPassword" >
        </div>
        <div class="alert alert-danger">
          패스워드를 입력해주세요
        </div>
        <div class="alert alert-danger">
          패스워드는 8자 이상이며 알파벳 소문자, 대문자, 숫자를 포함해야 합니다
        </div>
      </div>
      <div class="form-group row">
        <label for="inputPassword" class="col-sm-2 col-form-label">비밀번호 확인</label>
        <div class="col-sm-5">
          <input type="password" class="form-control" id="inputPasswordConfirm">
        </div>
        <div class="alert alert-danger">
          패스워드가 일치하지 않습니다
        </div>
      </div>
      <div class="form-group row">
        <label for="inputName" class="col-sm-2 col-form-label">이름</label>
        <div class="col-sm-5">
          <input type="text" class="form-control" id="inputName">
        </div>
      </div>
      <div class="form-group row">
        <label for="inputName" class="col-sm-2 col-form-label">닉네임</label>
        <div class="col-sm-5">
          <input type="text" class="form-control" id="inputNickName">
        </div>
        <button class="btn btn-danger" @click="checkNickName()">중복 확인</button>
        <span class="alert alert-danger">
        중복 확인이 필요합니다.
      </span>
        <span class="alert alert-danger">
        이미 닉네임이 존재합니다.
      </span>
      </div>
      <div class="form-group row">
        <label for="inputID" class="col-sm-2 col-form-label">학번</label>
        <div class="col-sm-5">
          <input type="text" class="form-control" id="inputID">
        </div>
      </div>
      <div class="form-group row">
        <label for="inputMajor1" class="col-sm-2 col-form-label">주전공</label>
        <div class="col-sm-5">
          <input type="text" class="form-control" id="inputMajor1">
        </div>
      </div>
      <br><br>
      <div class="alert alert-danger">
        잘못된 비밀번호 입니다.
      </div>
      <div class="form-group row">
        <button type="submit" class="btn btn-primary">
          <b-container>변경</b-container>
        </button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: 'ProfileUserInfo'
}
</script>

<style scoped>

</style>
