package sg.com.vc.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sg.com.vc.ui.account.usecase.AccountUseCase
import sg.com.vc.ui.account.usecase.AccountUseCaseImpl
import sg.com.vc.ui.authentication.usecase.AuthenticationUseCase
import sg.com.vc.ui.authentication.usecase.AuthenticationUseCaseImpl
import sg.com.vc.ui.catalogue.usecase.CatalogueUseCase
import sg.com.vc.ui.catalogue.usecase.CatalogueUseCaseImpl
import sg.com.vc.ui.contactus.usecase.ContactUseCase
import sg.com.vc.ui.contactus.usecase.ContactUseCaseImpl
import sg.com.vc.ui.convertVouchertoeVouchers.usecase.ConvertVoucherUseCase
import sg.com.vc.ui.convertVouchertoeVouchers.usecase.ConvertVoucherUseCaseImpl
import sg.com.vc.ui.forgotPasword.usecase.ForgotPasswordUseCase
import sg.com.vc.ui.forgotPasword.usecase.ForgotPasswordUseCaseImpl
import sg.com.vc.ui.games.usecase.GameUseCase
import sg.com.vc.ui.games.usecase.GameUseCaseImpl
import sg.com.vc.ui.helpcentre.usecase.HelpCentreUseCase
import sg.com.vc.ui.helpcentre.usecase.HelpCentreUseCaseImpl
import sg.com.vc.ui.home.home.usecase.HomeUseCase
import sg.com.vc.ui.home.home.usecase.HomeUseCaseImpl
import sg.com.vc.ui.activities.usecase.ActivitiesUseCase
import sg.com.vc.ui.activities.usecase.ActivitiesUseCaseImpl
import sg.com.vc.ui.kidsclub.usecase.KidsClubUseCaseImpl
import sg.com.vc.ui.kidsclub.usecase.KidsClubUseCse
import sg.com.vc.ui.member_qr_code.usecase.MemberQrcodeUseCase
import sg.com.vc.ui.member_qr_code.usecase.MemberQrcodeUseCaseImpl
import sg.com.vc.ui.more.usecase.MoreUseCase
import sg.com.vc.ui.more.usecase.MoreUseCaseImpl
import sg.com.vc.ui.notification.usecase.NotificationUseCase
import sg.com.vc.ui.notification.usecase.NotificationUseCaseImpl
import sg.com.vc.ui.parking.usecase.ParkingUseCase
import sg.com.vc.ui.parking.usecase.ParkingUseCaseImpl
import sg.com.vc.ui.payWithWallet.usecase.PayWithWalletUseCase
import sg.com.vc.ui.payWithWallet.usecase.PayWithWalletUseCaseImpl
import sg.com.vc.ui.redeemCode.usecase.RedeemCodeUseCase
import sg.com.vc.ui.redeemCode.usecase.RedeemCodeUseCaseImpl
import sg.com.vc.ui.settings.usecase.SettingUseCase
import sg.com.vc.ui.settings.usecase.SettingUseCaseImpl
import sg.com.vc.ui.splash.usecase.SplashUseCase
import sg.com.vc.ui.splash.usecase.SplashUseCaseImpl
import sg.com.vc.ui.stores.usecase.StoresUseCase
import sg.com.vc.ui.stores.usecase.StoresUseCaseImpl
import sg.com.vc.ui.submit_receipt.usecase.SubmitReceiptUseCaseImpl
import sg.com.vc.ui.submit_receipt.usecase.SubmitReceiptuseCase
import sg.com.vc.ui.wallet.usecase.WalletUseCase
import sg.com.vc.ui.wallet.usecase.WalletUseCaseImpl

//bind repository interfaces here
@InstallIn(SingletonComponent::class)
@Module
internal abstract class RepositoryModule {

    @Binds
    abstract fun bindSplashUseCase(splashUseCase: SplashUseCaseImpl?): SplashUseCase?

    @Binds
    abstract fun bindHomeUseCase(homeUseCase: HomeUseCaseImpl?): HomeUseCase?

    @Binds
    abstract fun bindStoresUseCase(storesUseCase: StoresUseCaseImpl?): StoresUseCase?

    @Binds
    abstract fun bindContactUseCase(contactUseCase: ContactUseCaseImpl?): ContactUseCase?

    @Binds
    abstract fun bindAuthenticationUseCase(authenticationUseCase: AuthenticationUseCaseImpl?): AuthenticationUseCase?

    @Binds
    abstract fun bindForgotPassword(forgotPasswordUseCse: ForgotPasswordUseCaseImpl?): ForgotPasswordUseCase?

    @Binds
    abstract fun bindHelpCentreUseCase(helpCentreUseCase: HelpCentreUseCaseImpl?): HelpCentreUseCase?

    @Binds
    abstract fun bindSettingUseCase(settingUseCase: SettingUseCaseImpl?): SettingUseCase?

    @Binds
    abstract fun bindAccountUseCase(accountUseCase: AccountUseCaseImpl?): AccountUseCase?
    @Binds
    abstract fun bindmemberQrcodeUseCase(memberQrcodeUseCase: MemberQrcodeUseCaseImpl?): MemberQrcodeUseCase?

    @Binds
    abstract fun bindSubmirReceiptUseCase(submirReceiptUseCase: SubmitReceiptUseCaseImpl?): SubmitReceiptuseCase?
    @Binds
    abstract fun bindRedeemCodeUseCase(redeemCodeUseCase: RedeemCodeUseCaseImpl?): RedeemCodeUseCase?

    @Binds
    abstract fun bindConvertVoucherUseCase(convertVoucherUseCase: ConvertVoucherUseCaseImpl?): ConvertVoucherUseCase?

    @Binds
    abstract fun bindActivitiesUseCase(activitiesUseCase: ActivitiesUseCaseImpl?): ActivitiesUseCase?

    @Binds
    abstract fun bindParkingUseCase(parkingUseCase: ParkingUseCaseImpl?): ParkingUseCase?

    @Binds
    abstract fun bindGameUseCase(gameUseCase: GameUseCaseImpl?): GameUseCase?

    @Binds
    abstract fun bindKidsClubUUseCase(kidsClubUUseCase: KidsClubUseCaseImpl?): KidsClubUseCse?

    @Binds
    abstract fun bindNotificationUseCase(notificationUseCase: NotificationUseCaseImpl?): NotificationUseCase?

    @Binds
    abstract fun bindWalletUseCase(walletUseCase: WalletUseCaseImpl?): WalletUseCase?

    @Binds
    abstract fun bindMoreUseCase(moreUseCase: MoreUseCaseImpl?): MoreUseCase?

    @Binds
    abstract fun bindCatalogueUseCase(catalogueUseCase: CatalogueUseCaseImpl?): CatalogueUseCase?

    @Binds
    abstract fun bindPayWithWalletUseCase(payWithWalletUseCase: PayWithWalletUseCaseImpl?): PayWithWalletUseCase?


}