package com.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * 
 * @author rahulsahu
 *
 */
public class BasePage {
	@Autowired
	private WebDriver driver;

	public BasePage() {
		PageFactory.initElements(driver, this);
	}

	public void openURL(String url) {
		driver.get(url);
	}

	public String getURL() {
		return driver.getCurrentUrl();
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	@FindBy(xpath = "//div[@class='c-griditem-overlay']")
	public List<WebElement> getVideoList;

	@FindBy(xpath = "//img[@class='img-responsive']")
	public List<WebElement> getMobileVideoList;

	// @FindBy(xpath = "//img[@class='img-responsive animate--fade-in']")
	@FindBy(xpath = "//img[contains(@class, 'img-responsive')]")
	public List<WebElement> getCategoryMobileVideoList;

	@FindBy(xpath = "//div[@class='nav__links']/a")
	public List<WebElement> getGenreList;

	@FindBy(xpath = "//div[@class='c-header']/div/a")
	public List<WebElement> getCategoryList;

	@FindBy(xpath = "//i[@class='icon viu-search']")
	public WebElement buttonSearch;

	@FindBy(xpath = "//div[@class='sign__btn']/button")
	public WebElement buttonSignUpIn;

	@FindBy(xpath = "//button[@class='menusidebar ']")
	public WebElement sideBarMenuButton;

	@FindBy(xpath = "//div[@class='c-pageHeading']/h1")
	public WebElement getCategoryName;

	@FindBy(xpath = "//input[@class='txtemail']")
	public WebElement username;

	@FindBy(xpath = "//input[@value='Next']")
	public WebElement buttonNext;

	@FindBy(xpath = "//input[@type='password']")
	public WebElement password;

	@FindBy(xpath = "//input[@class='btn-soclogin']")
	public WebElement buttonSignIn;

	@FindBy(xpath = "//div[@class='c-pageHeading']/h1")
	public WebElement getGenreName;

	@FindBy(id = "identifierId")
	public WebElement enterGoogleEmail;

	@FindBy(name = "password")
	public WebElement enterGooglePassword;

	@FindBy(xpath = "//div[@class='closeplayer']/button")
	public WebElement buttonClose;

	@FindBy(xpath = "//input[@class='txtsearch']")
	public WebElement searchBox;

	@FindBy(xpath = "//i[@class='icon viu-close-button']")
	public WebElement buttonSearchClose;

	@FindBy(xpath = "//button[@class='c-search-tags']")
	public List<WebElement> searchOptions;

	@FindBy(xpath = "//div[@class='srch__title']")
	public WebElement trendingSearchTitle;

	@FindBy(xpath = "//h4[@class='c-title title--md']")
	public List<WebElement> videosInResult;

	// @FindBy(xpath = "//a[contains(text(),'FAQ')]")
	@FindBy(xpath = "//a[@class='link faq-link']")
	public WebElement linkFAQ;

	@FindBy(xpath = "//i[@class='icon viu-playstore']")
	public WebElement linkGooglePlay;

	@FindBy(xpath = "//i[@class='icon viu-apple']")
	public WebElement linkAppleStore;

	@FindBy(xpath = "//i[@class='icon viu-facebook-official']")
	public WebElement linkFacebook;

	@FindBy(xpath = "//i[@class='icon viu-twitter']")
	public WebElement linkTwitter;

	@FindBy(xpath = "//div[@class='c-sidebar__footernav clearfix']/a[contains(text(),'Privacy')]")
	public WebElement linkPrivacy;

	@FindBy(xpath = "//div[@class='c-soclogin']")
	public WebElement socialPopUp;

	@FindBy(xpath = "//button[@class='usersidebar']")
	public WebElement userImg;

	@FindBy(xpath = "//div[@class='c-signemail']/a")
	public WebElement linkUseEmail;

	@FindBy(xpath = "//button[@class='btn-soclogin gm']")
	public WebElement buttonGoogle;

	// @FindBy(xpath = "//button[contains(text(),'Sign Out')]")
	@FindBy(css = "div.user__links > button:nth-child(2)")
	public WebElement buttonSignOut;

	@FindBy(xpath = "//div[@class='c-sidebar__category , ']/a")
	public List<WebElement> getSideBarGenreList;

	@FindBy(xpath = "//button[@class='user__login__st']")
	public WebElement buttonSignInMobile;

	@FindBy(css = "#identifierNext > content > span")
	public WebElement googleButtonNext;

	@FindBy(css = "#passwordNext > content > span")
	public WebElement pwdgoogleButtonNext;
}
