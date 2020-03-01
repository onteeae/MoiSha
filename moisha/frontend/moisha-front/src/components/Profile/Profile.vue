<template>
  <section class="profile-app">
    <div class="row">
      <div class="col-sm-9">
        <b-tabs>
          <b-tab title="회원정보">
              <ProfileUserInfo></ProfileUserInfo>
          </b-tab>
          <b-tab title="관심사">
              <ProfileInterest></ProfileInterest>
          </b-tab>
        </b-tabs>
      </div>
    </div>
  </section>

</template>

<script>
import ProfileUserInfo from './ProfileUserInfo'
import ProfileInterest from './ProfileInterest'
export default {
  name: 'Profile',
  components: {ProfileInterest, ProfileUserInfo}
}
</script>

<style scoped>
  .profile-app{
    padding-top: 5%;
    padding-left: 15%;
  }
</style>
